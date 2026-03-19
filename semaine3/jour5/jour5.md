## Jour 5 – Requêtes dérivées + pagination

Objectif du jour : enrichir l’API avec filtres, recherche, pagination et tri.

---

## 1. Méthodes dérivées dans `TaskRepository`

```java
List<Task> findByDone(boolean done);
List<Task> findByTitleContainingIgnoreCase(String keyword);
Page<Task> findByDone(boolean done, Pageable pageable);
Page<Task> findByOwnerId(Long ownerId, Pageable pageable);
```

Spring construit automatiquement la requête SQL à partir du nom.

---

## 2. Ajouter pagination et tri

Dans le contrôleur :

- `page` (défaut `0`)
- `size` (défaut `10`)
- `sortBy` (défaut `id`)
- `direction` (`asc`/`desc`)

Exemple service :

```java
Sort sort = direction.equalsIgnoreCase("desc")
        ? Sort.by(sortBy).descending()
        : Sort.by(sortBy).ascending();
Pageable pageable = PageRequest.of(page, size, sort);
return taskRepository.findAll(pageable);
```

---

## 3. Design d’endpoint conseillé

- `GET /tasks?done=true&page=0&size=10`
- `GET /tasks?keyword=spring`
- `GET /tasks?ownerId=3&page=0&size=5&sortBy=id&direction=desc`

---

## 4. Exercices du jour

1. Ajouter 2 méthodes dérivées dans `TaskRepository`.
2. Exposer un endpoint filtré sur `done`.
3. Exposer un endpoint paginé/trié.
4. Tester plusieurs combinaisons de query params.

---

## 5. Validation du jour

Tu as fini si :

- tu ne renvoies plus forcément toute la table d’un coup,
- tu sais filtrer, paginer et trier côté backend.

