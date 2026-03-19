## Jour 4 – Protéger `/tasks` avec JWT

Objectif : exiger un token pour les endpoints métier.

## À faire

- `Authorization: Bearer <token>`
- Filtre JWT injecte l’utilisateur dans `SecurityContext`
- Contrôleurs `/tasks/**` accessibles uniquement authentifiés

## Bonus

- Associer task à user courant
- Interdire accès aux tâches d’un autre user

## Validation

- Sans token -> 401
- Avec token valide -> 200

