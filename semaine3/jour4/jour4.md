## Jour 4 – Relations JPA (`User` ↔ `Task`)

Objectif du jour : introduire une vraie relation entre entités, pour préparer la sécurité de la semaine 5.

---

## 1. Créer l’entité `User`

Champs minimum :

- `id`
- `email` (unique)
- `name`

---

## 2. Lier `Task` à `User`

Dans `Task` :

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "owner_id", nullable = false)
private User owner;
```

Dans `User` :

```java
@OneToMany(mappedBy = "owner")
private List<Task> tasks = new ArrayList<>();
```

---

## 3. Repository et service

- Créer `UserRepository`.
- Dans le service de tâches, créer avec un `ownerId` :
  - charger le user,
  - l’affecter à la task,
  - persister la task.

---

## 4. Attention au JSON (boucles infinies)

Si tu renvoies les entités brutes :

- `Task` contient `User`,
- `User` contient `tasks`,
- possible boucle de sérialisation.

Solution recommandée :

- renvoyer des DTOs (ex: `TaskResponse` avec `ownerId`/`ownerEmail`),
- éviter d’exposer les entités directement.

---

## 5. Exercices du jour

1. Créer `User` + repository.
2. Ajouter la relation `Task.owner`.
3. Modifier `POST /tasks` pour accepter `ownerId`.
4. Créer endpoint `GET /users/{id}/tasks`.

---

## 6. Validation du jour

Tu as fini si :

- une tâche est liée à un user existant,
- les requêtes récupèrent correctement les tâches par utilisateur,
- tu comprends pourquoi les DTO sont importants avec des relations JPA.

