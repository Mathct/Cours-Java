## Jour 4 – Service propre et exceptions métier

Objectif du jour : clarifier l’architecture pour éviter les contrôleurs “fat” et centraliser les règles métier.

---

## 1. Répartition des responsabilités

- **Controller** : reçoit HTTP, valide entrée, renvoie DTO/réponse HTTP.
- **Service** : applique logique métier (règles, orchestration).
- **Repository** : lit/écrit en base.

---

## 2. Exceptions métier

Créer des exceptions dédiées :

- `TaskNotFoundException`
- `BusinessException` (ex : “tâche déjà terminée”)

Dans le service :

- ne pas renvoyer `null`,
- lever des exceptions explicites.

---

## 3. Exemple de règle métier

```java
public TaskResponse markDone(Long id) {
    Task task = repository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException(id));
    if (task.isDone()) {
        throw new BusinessException("La tâche est déjà terminée");
    }
    task.setDone(true);
    return mapper.toResponse(repository.save(task));
}
```

---

## 4. Exercices du jour

1. Supprimer les `null` de ton service.
2. Lever des exceptions métier explicites.
3. Simplifier le contrôleur pour qu’il délègue tout au service.

---

## 5. Validation du jour

Tu as fini si :

- les règles métier sont dans le service,
- le contrôleur est court et lisible,
- les erreurs sont gérées globalement via `@ControllerAdvice`.

