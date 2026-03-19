## Jour 4 – Service propre et exceptions métier

Objectif : clarifier les responsabilités.

## Règles

- Controller : HTTP + DTO
- Service : logique métier
- Repository : accès données

## À faire

- Lever `TaskNotFoundException` dans service (pas `null`)
- Lever `BusinessException` si règle métier non respectée
- Garder contrôleurs fins

## Validation

- Plus de `if (x == null)` dispersés dans contrôleurs.

