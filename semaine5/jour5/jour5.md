## Jour 5 – Rôles et autorisations simples

Objectif : distinguer user/admin.

## À faire

- Ajouter rôle dans `User` (`ROLE_USER`, `ROLE_ADMIN`)
- Restreindre endpoints admin :
  - ex: suppression globale
- Utiliser `hasRole("ADMIN")` dans config sécurité

## Validation

- User standard ne peut pas accéder aux routes admin.

