## Jour 4 – Relations JPA (`User` ↔ `Task`)

Objectif : introduire une relation simple entre utilisateurs et tâches.

## Entités

- `User` : id, email, name
- `Task` : owner (ManyToOne vers `User`)

Exemple dans `Task` :

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "owner_id")
private User owner;
```

Exemple dans `User` :

```java
@OneToMany(mappedBy = "owner")
private List<Task> tasks = new ArrayList<>();
```

## Points clés

- Éviter les boucles JSON (utiliser DTOs, ou `@JsonIgnore` temporairement)
- Créer les tâches avec un `ownerId`

## Validation

- Une tâche est liée à un user existant.
- Tu peux lister les tâches d’un user.

