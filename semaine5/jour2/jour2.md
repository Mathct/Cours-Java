## Jour 2 – Utilisateur + endpoint login

Objectif : préparer l’authentification.

## À faire

- Entité `User` (email, passwordHash, role)
- `UserRepository`
- service `UserDetailsService`
- endpoint `POST /auth/login`

## Important

- Stocker mot de passe hashé (`BCryptPasswordEncoder`)

## Validation

- Login valide retourne une réponse d’auth.

