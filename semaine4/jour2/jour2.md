## Jour 2 – Validation avancée

Objectif du jour : empêcher les données invalides d’entrer dans ton système dès la couche API.

---

## 1. Valider les DTO

Exemple `CreateTaskRequest` :

```java
@NotBlank(message = "Le titre est obligatoire")
@Size(min = 3, max = 100, message = "Le titre doit faire entre 3 et 100 caractères")
private String title;

@Size(max = 500, message = "La description est trop longue")
private String description;

@NotNull(message = "ownerId est obligatoire")
private Long ownerId;
```

---

## 2. Activer dans les endpoints

```java
public ResponseEntity<TaskResponse> create(@Valid @RequestBody CreateTaskRequest req)
```

Même principe pour update.

---

## 3. Valider les paramètres d’URL

Dans le contrôleur :

```java
@GetMapping("/{id}")
public TaskResponse getOne(@PathVariable @Positive Long id) { ... }
```

Ajouter `@Validated` sur la classe contrôleur pour activer la validation des params.

---

## 4. Exercices du jour

1. Ajouter contraintes de validation sur tous les DTO.
2. Mettre des messages personnalisés.
3. Ajouter validation des path/query params.
4. Tester des payloads invalides.

---

## 5. Validation du jour

Tu as fini si :

- les requêtes invalides renvoient 400 de façon systématique,
- les messages d’erreur sont compréhensibles pour le client API.

