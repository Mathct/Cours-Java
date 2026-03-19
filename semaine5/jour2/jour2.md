## Jour 2 – Utilisateur + endpoint login

Objectif du jour : mettre en place l’authentification utilisateur de base.

---

## 1. Modèle utilisateur

Entité `User` minimale :

- `id`
- `email` (unique)
- `passwordHash`
- `role` (`ROLE_USER` / `ROLE_ADMIN`)

---

## 2. Couche sécurité

- `UserRepository` avec `findByEmail`.
- Implémenter `UserDetailsService` pour charger l’utilisateur.
- Configurer un `PasswordEncoder` :

```java
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

---

## 3. Endpoint login

Créer `POST /auth/login` :

- reçoit `email` + `password`,
- vérifie les credentials,
- renvoie une réponse d’auth (token à venir jour 3).

---

## 4. Exercices du jour

1. Créer entité/repository `User`.
2. Ajouter `UserDetailsService`.
3. Créer DTO `LoginRequest`.
4. Implémenter endpoint login basique.

---

## 5. Validation du jour

Tu as fini si :

- un login valide est accepté,
- les mots de passe sont hashés et jamais stockés en clair.

