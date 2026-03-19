## Jour 2 – Validation avancée

Objectif : renforcer les contrôles d’entrée.

## Exemples

```java
@NotBlank
@Size(min = 3, max = 100)
private String title;

@Size(max = 500)
private String description;
```

Sur endpoints :

```java
public ResponseEntity<TaskResponse> create(@Valid @RequestBody CreateTaskRequest req)
```

## Plus loin

- Validation personnalisée (ex: titre interdit)
- Groupes de validation (optionnel)

## Validation

- Requêtes invalides -> 400 systématique.

