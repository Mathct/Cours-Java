## Jour 2 – Premier `@RestController` et endpoint GET simple

Objectif du jour : ajouter un premier contrôleur REST dans ton projet Spring Boot et exposer un endpoint GET qui renvoie une réponse simple (texte ou JSON).

---

## 1. Créer un package `controller`

Dans `src/main/java/...`, crée un package (dossier) :

- `controller`

Par exemple : `com.example.tasksapi.controller`.

---

## 2. Créer un premier contrôleur

Crée une classe `HelloController` dans ce package :

```java
package com.example.tasksapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Bonjour depuis Spring Boot !";
    }
}
```

Explications :

- `@RestController` : indique à Spring qu’il s’agit d’un contrôleur REST (les méthodes renvoient directement le corps de la réponse).
- `@GetMapping("/hello")` : mappe les requêtes GET sur `/hello` à la méthode `sayHello`.
- La méthode renvoie un `String` qui sera renvoyé tel quel dans la réponse HTTP.

---

## 3. Tester le contrôleur

Redémarre ton application (ou laisse-la tourner si ton IDE fait le reload automatique) puis teste :

- Dans le navigateur : `http://localhost:8080/hello`
- Ou avec `curl` :

```bash
curl http://localhost:8080/hello
```

Tu dois voir :

```text
Bonjour depuis Spring Boot !
```

---

## 4. Retourner du JSON simple

Au lieu d’un `String`, tu peux renvoyer un **objet**, qui sera automatiquement converti en JSON par Spring (via Jackson).

Crée une petite classe DTO, par exemple `HelloResponse` dans un package `dto` :

```java
package com.example.tasksapi.dto;

public class HelloResponse {
    private String message;

    public HelloResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```

Puis modifie ton contrôleur :

```java
import com.example.tasksapi.dto.HelloResponse;

@RestController
public class HelloController {

    @GetMapping("/hello-json")
    public HelloResponse sayHelloJson() {
        return new HelloResponse("Bonjour en JSON depuis Spring Boot !");
    }
}
```

Teste :

```bash
curl http://localhost:8080/hello-json
```

Réponse attendue (format JSON) :

```json
{"message":"Bonjour en JSON depuis Spring Boot !"}
```

---

## 5. Exercices du jour

1. Créer `HelloController` avec un endpoint GET `/hello` qui renvoie un `String`.
2. Créer un DTO `HelloResponse` et un endpoint `/hello-json` qui renvoie du JSON.
3. Ajouter un endpoint `/ping` qui renvoie `{ "status": "ok" }` (via une petite classe DTO ou une `Map<String, String>`).

---

## 6. Validation du jour

À la fin du Jour 2 de la semaine 2, tu dois être capable de :

- créer un package de contrôleurs dans un projet Spring Boot ;
- annoter une classe avec `@RestController` ;
- exposer un endpoint GET simple ;
- renvoyer soit du texte brut, soit un petit JSON.

Le prochain jour, tu commenceras à manipuler des **paramètres** (path params, query params) et à structurer les endpoints pour les tâches (`/tasks`).

