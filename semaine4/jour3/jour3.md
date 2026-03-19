## Jour 3 – Gestion d’erreurs globale

Objectif du jour : uniformiser toutes les erreurs de l’API pour aider le front et le debug.

---

## 1. Créer un format d’erreur standard

Exemple DTO `ApiError` :

```java
public class ApiError {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
```

---

## 2. Créer un `@ControllerAdvice`

Gérer au minimum :

- `MethodArgumentNotValidException` -> 400
- `TaskNotFoundException` -> 404
- `Exception` -> 500

---

## 3. Gérer les erreurs de validation proprement

Pour `MethodArgumentNotValidException`, renvoyer :

- message général,
- plus un objet `fieldErrors` avec les détails par champ.

---

## 4. Exercices du jour

1. Créer `ApiError`.
2. Créer `GlobalExceptionHandler`.
3. Gérer au moins 3 types d’erreurs (400/404/500).
4. Tester des endpoints avec erreurs pour vérifier le format.

---

## 5. Validation du jour

Tu as fini si :

- toutes les erreurs HTTP renvoient un JSON cohérent,
- le front peut lire facilement le message et le champ en erreur.

