## Jour 3 – JWT (génération + validation)

Objectif : mettre en place des tokens JWT.

## Composants

- `JwtService` :
  - `generateToken(user)`
  - `extractUsername(token)`
  - `isTokenValid(token, user)`
- `JwtAuthenticationFilter`

## Config

- secret robuste en variable d’environnement
- expiration courte (ex: 1h)

## Validation

- Login renvoie JWT
- Token valide permet accès endpoint protégé

