## Jour 5 – Requêtes dérivées + pagination

Objectif : aller au-delà du CRUD de base.

## Requêtes dérivées

Dans `TaskRepository` :

```java
List<Task> findByDone(boolean done);
List<Task> findByTitleContainingIgnoreCase(String keyword);
Page<Task> findByDone(boolean done, Pageable pageable);
```

## Pagination / tri

Dans contrôleur :

- `page` (défaut 0)
- `size` (défaut 10)
- `sort` (ex: `id,desc`)

Exemple :

```java
PageRequest.of(page, size, Sort.by("id").descending())
```

## Validation

- `GET /tasks?done=false`
- `GET /tasks?page=0&size=5`
- `GET /tasks/search?keyword=java`

