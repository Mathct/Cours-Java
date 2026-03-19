## Jour 3 – Gestion d’erreurs globale

Objectif : réponses d’erreur uniformes.

## À implémenter

- `@ControllerAdvice`
- gestion :
  - `MethodArgumentNotValidException` -> 400
  - `TaskNotFoundException` -> 404
  - fallback `Exception` -> 500

## Format conseillé

```json
{
  "timestamp": "...",
  "status": 404,
  "error": "Not Found",
  "message": "Task 12 introuvable",
  "path": "/tasks/12"
}
```

## Validation

- Toutes les erreurs suivent le même format JSON.

