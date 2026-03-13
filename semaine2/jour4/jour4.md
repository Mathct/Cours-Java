## Jour 4 – Endpoint POST : création de tâches en mémoire

Objectif du jour : ajouter un endpoint POST pour créer de nouvelles tâches, en recevant des données JSON et en les stockant dans la `List` du `TaskService`.

---

## 1. DTO de création de tâche

On évite de réutiliser directement le modèle interne pour l’entrée. Crée un DTO `CreateTaskRequest` :

```java
package com.example.tasksapi.dto;

public class CreateTaskRequest {
    private String title;
    private String description;

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
}
```

Ce DTO représente le corps JSON attendu lors de la création.

---

## 2. Ajouter une méthode d’ajout dans `TaskService`

Dans `TaskService` :

```java
public Task addTask(String title, String description) {
    Task task = new Task(nextId++, title, description, false);
    tasks.add(task);
    return task;
}
```

---

## 3. Endpoint POST dans `TaskController`

Dans `TaskController` :

```java
import com.example.tasksapi.dto.CreateTaskRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@PostMapping
public Task createTask(@RequestBody CreateTaskRequest request) {
    return taskService.addTask(request.getTitle(), request.getDescription());
}
```

- `@PostMapping` (sans chemin) : correspond à `POST /tasks`.
- `@RequestBody` : indique que les données viennent du corps de la requête (JSON).

Exemple de requête JSON :

```json
{
  "title": "Nouvelle tâche",
  "description": "Créée via POST"
}
```

---

## 4. Tester l’endpoint POST

Avec `curl` :

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Ma première tâche","description":"Créée via POST"}'
```

La réponse doit être la tâche créée (avec un `id` et `done` à `false`).

Ensuite, teste :

```bash
curl http://localhost:8080/tasks
```

Tu dois y voir la nouvelle tâche ajoutée.

---

## 5. Exercices du jour

1. Créer le DTO `CreateTaskRequest`.
2. Ajouter une méthode `addTask` dans `TaskService`.
3. Ajouter l’endpoint `POST /tasks` dans `TaskController`.
4. Tester la création de plusieurs tâches puis vérifier qu’elles apparaissent dans `GET /tasks`.

---

## 6. Validation du jour

À la fin du Jour 4 de la semaine 2, tu dois être capable de :

- recevoir des données JSON dans un contrôleur Spring via `@RequestBody` ;
- créer de nouvelles entités en mémoire dans ton service ;
- renvoyer la ressource créée au client.

Le prochain jour, tu ajouteras les endpoints **PUT** (mise à jour) et **DELETE** (suppression), avec de meilleurs codes HTTP.

