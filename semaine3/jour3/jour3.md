## Jour 3 – `JpaRepository` et CRUD

Objectif : remplacer la `List` en mémoire par un repository JPA.

## Repository

```java
public interface TaskRepository extends JpaRepository<Task, Long> {
}
```

## Service

- `getAllTasks()` -> `taskRepository.findAll()`
- `getTaskById(id)` -> `taskRepository.findById(id)`
- `createTask(...)` -> `taskRepository.save(task)`
- `deleteTask(id)` -> `taskRepository.deleteById(id)`

## Contrôleur

- Adapter `id` en `Long`
- Retourner 404 si `findById` est vide

## Validation

- POST crée en DB.
- GET lit depuis DB.
- DELETE supprime réellement.

