## Jour 3 – JWT (génération + validation)

Objectif du jour : générer un JWT au login et valider ce token sur les requêtes suivantes.

---

## 1. Créer `JwtService`

Méthodes clés :

- `generateToken(UserDetails user)`
- `extractUsername(String token)`
- `isTokenValid(String token, UserDetails user)`

Inclure :

- clé secrète forte (env var),
- expiration (ex. 1h).

---

## 2. Créer `JwtAuthenticationFilter`

Rôle :

- lire `Authorization: Bearer ...`,
- extraire/valider token,
- charger user,
- remplir `SecurityContext`.

---

## 3. Brancher dans la sécurité

Ajouter le filtre JWT avant `UsernamePasswordAuthenticationFilter` dans `SecurityFilterChain`.

---

## 4. Exercices du jour

1. Implémenter `JwtService`.
2. Modifier login pour renvoyer token JWT.
3. Implémenter filtre JWT.
4. Vérifier qu’un token valide authentifie l’utilisateur.

---

## 5. Validation du jour

Tu as fini si :

- `POST /auth/login` renvoie un JWT,
- une requête avec ce token passe sur route protégée.

