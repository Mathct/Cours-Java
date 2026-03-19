## Jour 5 – Tests unitaires (JUnit + Mockito)

Objectif : tester la logique service sans Spring complet.

## Dépendances

- `spring-boot-starter-test` (inclut JUnit 5 + Mockito)

## Exemple à tester

- `TaskService.createTask(...)`
- `TaskService.markDone(id)`
- `TaskService.getById(id)` -> exception si absent

## Pattern

- Given / When / Then
- Mock `TaskRepository`
- Vérifier interactions `verify(...)`

## Validation

- Suite de tests unitaires passe en vert.

