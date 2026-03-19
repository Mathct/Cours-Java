## Jour 1 – DTO request/response

Objectif du jour : ne plus renvoyer les entités JPA dans tes endpoints, et définir un contrat API clair via des DTO.

---

## 1. DTO à créer

- `CreateTaskRequest` (entrée POST)
- `UpdateTaskRequest` (entrée PUT/PATCH)
- `TaskResponse` (sortie API)

Exemple `TaskResponse` :

```java
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private boolean done;
    private Long ownerId;
}
```

---

## 2. Mapping entité <-> DTO

Option simple (manuelle) dans le service :

```java
private TaskResponse toResponse(Task task) {
    TaskResponse dto = new TaskResponse();
    dto.setId(task.getId());
    dto.setTitle(task.getTitle());
    dto.setDescription(task.getDescription());
    dto.setDone(task.isDone());
    dto.setOwnerId(task.getOwner().getId());
    return dto;
}
```

---

## 3. Adapter les endpoints

- `GET /tasks` retourne `List<TaskResponse>`
- `GET /tasks/{id}` retourne `TaskResponse`
- `POST /tasks` reçoit `CreateTaskRequest` et retourne `TaskResponse`

---

## 4. Exercices du jour

1. Créer les 3 DTO.
2. Mapper manuellement dans le service.
3. Modifier tous les endpoints tâches pour renvoyer `TaskResponse`.
4. Vérifier qu’aucune entité JPA brute n’est exposée.

---

## 5. Validation du jour

Tu as fini si :

- ton API expose un contrat stable,
- un changement DB interne n’oblige pas à changer le JSON public.

