## Jour 6 – Validation simple et gestion d’erreurs basique

Objectif du jour : ajouter de la **validation** sur les données reçues (par ex. titre non vide) et commencer une gestion d’erreurs un peu plus propre (erreurs JSON).

---

## 1. Ajouter Bean Validation (Hibernate Validator)

Dans `pom.xml`, vérifie que tu as la dépendance :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

Si ce n’est pas le cas, ajoute-la (dans la section `<dependencies>`), puis recharge Maven.

---

## 2. Ajouter des annotations de validation sur les DTO

Dans `CreateTaskRequest` (et `UpdateTaskRequest` si besoin) :

```java
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTaskRequest {

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    // getters/setters
}
```

- `@NotBlank` : le champ ne doit pas être vide (ni null, ni string vide).
- `@Size(max = 100)` : limite la longueur.

---

## 3. Activer la validation dans le contrôleur

Dans `TaskController`, sur les méthodes POST/PUT :

```java
import jakarta.validation.Valid;

@PostMapping
public ResponseEntity<Task> createTask(@Valid @RequestBody CreateTaskRequest request) {
    Task created = taskService.addTask(request.getTitle(), request.getDescription());
    return ResponseEntity.status(201).body(created);
}
```

- `@Valid` : déclenche la validation Bean Validation sur l’objet reçu.
- Si les contraintes ne sont pas respectées, Spring renvoie automatiquement une **erreur 400** avec des détails.

Tu peux faire pareil pour `UpdateTaskRequest`.

---

## 4. Gestion d’erreurs globale simple (optionnel mais recommandé)

Pour rendre les erreurs plus propres, tu peux définir un handler global :

```java
package com.example.tasksapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
```

Résultat : les erreurs de validation renvoient un JSON du type :

```json
{
  "title": "must not be blank"
}
```

---

## 5. Exercices du jour

1. Ajouter `spring-boot-starter-validation` dans `pom.xml` si nécessaire.
2. Annoter `CreateTaskRequest` avec :
   - `@NotBlank` sur `title` ;
   - `@Size(max = 100)` sur `title` ;
   - `@Size(max = 500)` sur `description`.
3. Ajouter `@Valid` sur le `@RequestBody` de `POST /tasks` (et PUT si tu l’utilises).
4. Tester :
   - envoyer une requête sans `title` ou avec une chaîne vide → doit renvoyer 400.
5. (Optionnel) Ajouter un `@ControllerAdvice` pour formater les erreurs de validation.

---

## 6. Validation du jour

À la fin du Jour 6 de la semaine 2, tu dois être capable de :

- protéger ton API contre des données invalides en utilisant `@Valid` + annotations ;
- voir comment Spring génère automatiquement des réponses 400 pour les validations ratées ;
- commencer à personnaliser le format des erreurs JSON.

Le prochain jour, tu consolideras tout ça dans un **mini-projet API complet** pour clôturer la semaine.

