## Jour 1 – DTO request/response

Objectif : ne plus exposer directement les entités JPA.

## À faire

- Créer :
  - `CreateTaskRequest`
  - `UpdateTaskRequest`
  - `TaskResponse`
- Mapper entité -> response dans le service (ou mapper dédié)

## Pourquoi

- Découpler API et modèle DB
- Contrôler ce que tu exposes

## Validation

- Les endpoints renvoient `TaskResponse` uniquement.

