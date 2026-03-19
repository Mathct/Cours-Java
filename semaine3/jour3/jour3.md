## Jour 3 – `JpaRepository` et CRUD

Objectif du jour : remplacer définitivement la `List<Task>` en mémoire par un repository Spring Data JPA.

---

## 1. Créer le repository

```java
public interface TaskRepository extends JpaRepository<Task, Long> {
}
```

Avec `JpaRepository`, tu obtiens déjà :

- `findAll()`
- `findById(id)`
- `save(entity)`
- `deleteById(id)`

---

## 2. Adapter le service

Exemple de service :

```java
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(String title, String description) {
        return taskRepository.save(new Task(title, description));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
```

---

## 3. Adapter le contrôleur REST

- passer les IDs en `Long`,
- gérer le cas “not found” avec 404.

Exemple GET par ID :

```java
@GetMapping("/{id}")
public ResponseEntity<Task> getById(@PathVariable Long id) {
    return taskService.getTaskById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}
```

---

## 4. Tests manuels API

1. `POST /tasks` pour créer une tâche.
2. `GET /tasks` pour vérifier qu’elle est persistée.
3. Redémarrer l’application.
4. `GET /tasks` : la donnée doit toujours être là (preuve de persistance DB).

---

## 5. Exercices du jour

1. Créer `TaskRepository`.
2. Refactorer ton service pour utiliser le repository.
3. Adapter les endpoints existants.
4. Vérifier que les données survivent au redémarrage.

---

## 6. Validation du jour

Tu as terminé si :

- tous les endpoints CRUD marchent sans stockage en mémoire,
- les opérations lisent/écrivent en base via JPA.

