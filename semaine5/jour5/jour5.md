## Jour 5 – Rôles et autorisations simples

Objectif du jour : différencier les capacités d’un utilisateur standard et d’un administrateur.

---

## 1. Modèle de rôles

Dans `User`, stocker :

- `ROLE_USER`
- `ROLE_ADMIN`

Mapper ces rôles vers `GrantedAuthority`.

---

## 2. Restreindre les endpoints

Exemples :

- `/admin/**` -> `hasRole("ADMIN")`
- `/tasks/**` -> `hasAnyRole("USER", "ADMIN")`

Tu peux le faire en config sécurité ou via `@PreAuthorize`.

---

## 3. Cas métier typiques

- USER : gère ses propres tâches.
- ADMIN : peut lister/supprimer globalement.

---

## 4. Exercices du jour

1. Ajouter rôles dans l’entité user.
2. Créer un endpoint admin test.
3. Vérifier qu’un USER obtient 403.
4. Vérifier qu’un ADMIN passe.

---

## 5. Validation du jour

Tu as fini si :

- les permissions changent selon le rôle,
- les routes sensibles sont réellement restreintes.

