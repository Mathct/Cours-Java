## Jour 7 – Mini-projet semaine 3 (persisté)

Objectif : finaliser une API avec vraie persistance.

## Checklist

- `Task` entité JPA persistée
- `TaskRepository` + filtres simples
- CRUD complet branché DB
- Relation `Task` -> `User` (au moins basique)
- Flyway activé

## Scénario de test

1. Créer un user
2. Créer des tasks liées au user
3. Lister tasks par user
4. Mettre à jour `done=true`
5. Supprimer une task

## Résultat attendu

Tu n’utilises plus de stockage en mémoire : toute donnée est en DB.

