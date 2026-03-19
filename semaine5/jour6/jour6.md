## Jour 6 – Tests sécurité + hardening basique

Objectif : vérifier que la sécurité tient.

## Tests

- login ok / ko
- accès protégé sans token -> 401
- token expiré -> rejet
- route admin avec user non admin -> 403

## Hardening

- secrets via variables d’environnement
- CORS minimal (si front séparé)
- messages d’erreur non verbeux

## Validation

- Tests sécurité essentiels en vert.

