## Jour 5 – PUT/DELETE, codes HTTP et `ResponseEntity`

Objectif du jour : ajouter les endpoints de mise à jour (PUT) et suppression (DELETE) des tâches, et utiliser `ResponseEntity` pour mieux contrôler les codes HTTP.

---

## 1. Mettre à jour une tâche (PUT)

### 1.1. DTO de mise à jour

Tu peux réutiliser `CreateTaskRequest` ou créer un `UpdateTaskRequest`. Pour simplifier, on réutilise souvent le même format, mais voici une version dédiée :

```java
package com.example.tasksapi.dto;

public class UpdateTaskRequest {
    private String title;
    private String description;
    private Boolean done; // Boolean pour pouvoir être null si non envoyé

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
```

### 1.2. Méthode de mise à jour dans `TaskService`

```java
public Task updateTask(int id, String title, String description, Boolean done) {
    Task task = getTaskById(id);
    if (task == null) {
        return null; // on améliorera plus tard avec une exception
    }
    if (title != null) {
        // ajouter un setter dans Task si besoin
        // task.setTitle(title);
    }
    if (description != null) {
        // task.setDescription(description);
    }
    if (done != null) {
        task.setDone(done);
    }
    return task;
}
```

Ajoute au besoin les setters manquants dans `Task`.

### 1.3. Endpoint PUT

Dans `TaskController` :

```java
import com.example.tasksapi.dto.UpdateTaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@PutMapping("/{id}")
public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody UpdateTaskRequest request) {
    Task updated = taskService.updateTask(id, request.getTitle(), request.getDescription(), request.getDone());
    if (updated == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
}
```

- Si la tâche n’existe pas → **404 Not Found**.
- Si la mise à jour réussit → **200 OK** avec la tâche mise à jour.

---

## 2. Supprimer une tâche (DELETE)

### 2.1. Méthode de suppression dans `TaskService`

```java
public boolean deleteTask(int id) {
    Task task = getTaskById(id);
    if (task == null) {
        return false;
    }
    tasks.remove(task);
    return true;
}
```

### 2.2. Endpoint DELETE

```java
import org.springframework.web.bind.annotation.DeleteMapping;

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable int id) {
    boolean deleted = taskService.deleteTask(id);
    if (!deleted) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build(); // 204 No Content
}
```

- Si la tâche n’existe pas → 404.
- Si la suppression réussit → 204 No Content.

---

## 3. Rappel rapide sur quelques codes HTTP

- **200 OK** : requête réussie, réponse avec contenu.
- **201 Created** : ressource créée (idéal pour POST) + en-tête `Location` (optionnel pour l’instant).
- **204 No Content** : requête réussie, pas de contenu (souvent pour DELETE ou PUT sans corps).
- **400 Bad Request** : requête invalide (corps JSON mal formé, données invalides…).
- **404 Not Found** : ressource non trouvée.

---

## 4. Exercices du jour

1. Créer `UpdateTaskRequest` (ou réutiliser `CreateTaskRequest` si tu préfères, avec champs optionnels).\n2. Ajouter la méthode `updateTask` dans `TaskService`.\n3. Ajouter l’endpoint `PUT /tasks/{id}` retournant `ResponseEntity<Task>`.\n4. Ajouter la méthode `deleteTask` dans `TaskService`.\n5. Ajouter l’endpoint `DELETE /tasks/{id}` retournant `ResponseEntity<Void>`.\n6. Tester les cas :\n   - id existant vs id inexistant ;\n   - mise à jour de `done` à `true` ;\n   - suppression d’une tâche puis vérification via `GET /tasks`.\n\n---\n\n## 5. Validation du jour\n\nÀ la fin du Jour 5 de la semaine 2, tu dois être capable de :\n\n- exposer les 4 opérations CRUD de base sur `/tasks` (GET/POST/PUT/DELETE) ;\n- utiliser `ResponseEntity` pour contrôler un minimum les codes HTTP ;\n- gérer les cas \"ressource non trouvée\" avec un **404**.\n\nLe prochain jour, tu amélioreras la **validation** des entrées et la **gestion d’erreurs**.\n+
