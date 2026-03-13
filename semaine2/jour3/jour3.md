## Jour 3 – Endpoints GET : liste, détail, path params, query params

Objectif du jour : créer des endpoints GET pour lister des tâches et en récupérer une par id, en utilisant les **path params** et éventuellement des **query params**.

---

## 1. Modèle `Task` côté API (simple)

Crée une classe `Task` dans un package `model` ou `task` (sans base de données pour l’instant) :

```java
package com.example.tasksapi.model;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;

    public Task(int id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
```

Tu peux réutiliser la structure que tu as déjà pour `Task` en Java “pur”.

---

## 2. Service en mémoire pour les tâches

Crée une classe `TaskService` dans un package `service` :

```java
package com.example.tasksapi.service;

import com.example.tasksapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public TaskService() {
        // Données de test
        tasks.add(new Task(nextId++, "Découvrir Spring Boot", "Semaine 2", false));
        tasks.add(new Task(nextId++, "Créer une API REST", "Sans base de données", false));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null); // pour l'instant, null si pas trouvé (on améliorera)
    }
}
```

`@Service` indique à Spring qu’il s’agit d’un composant de la couche métier.

---

## 3. Contrôleur `TaskController` – endpoints GET

Crée `TaskController` dans `controller` :

```java
package com.example.tasksapi.controller;

import com.example.tasksapi.model.Task;
import com.example.tasksapi.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }
}
```

- `@RequestMapping("/tasks")` : préfixe pour tous les endpoints de ce contrôleur.
- `@GetMapping` sans chemin : correspond à `GET /tasks`.
- `@GetMapping("/{id}")` + `@PathVariable int id` : path param, `GET /tasks/1` → `id = 1`.

---

## 4. (Optionnel) Query params

Tu peux ajouter un filtre simple via **query params** (par exemple `done=true`).

```java
import org.springframework.web.bind.annotation.RequestParam;

@GetMapping("/search")
public List<Task> searchTasks(@RequestParam(required = false) Boolean done) {
    if (done == null) {
        return taskService.getAllTasks();
    }
    return taskService.getAllTasks().stream()
            .filter(t -> t.isDone() == done)
            .toList();
}
```

- `@RequestParam(required = false)` : paramètre optionnel, récupéré depuis l’URL, par ex. `/tasks/search?done=true`.

---

## 5. Tests rapides

- `GET http://localhost:8080/tasks` → doit renvoyer la liste des tâches (JSON).
- `GET http://localhost:8080/tasks/1` → doit renvoyer la tâche avec `id = 1` si elle existe.
- (optionnel) `GET http://localhost:8080/tasks/search?done=false` → liste filtrée.

---

## 6. Exercices du jour

1. Créer la classe `Task` (modèle) côté API.
2. Créer `TaskService` avec quelques données en mémoire et les méthodes :
   - `getAllTasks()`
   - `getTaskById(int id)`
3. Créer `TaskController` avec :
   - `GET /tasks` → liste des tâches ;
   - `GET /tasks/{id}` → tâche par id.
4. (Optionnel) Ajouter un endpoint de recherche avec un query param `done`.

---

## 7. Validation du jour

À la fin du Jour 3 de la semaine 2, tu dois être capable de :

- exposer des endpoints GET pour une ressource `Task` ;
- utiliser `@PathVariable` pour lire un id dans l’URL ;
- structurer un contrôleur autour d’un service en mémoire.

Le prochain jour, tu ajouteras les endpoints **POST** pour créer des tâches côté serveur.

