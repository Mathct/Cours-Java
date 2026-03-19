## Jour 6 – Tests sécurité + hardening basique

Objectif du jour : prouver que ta sécurité fonctionne et réduire les risques courants.

---

## 1. Tests sécurité indispensables

- login succès/échec,
- endpoint protégé sans token -> 401,
- token invalide/expiré -> 401,
- endpoint admin avec rôle USER -> 403.

Automatiser ces scénarios avec tests d’intégration.

---

## 2. Hardening minimum

- secret JWT en variable d’environnement,
- expiration de token raisonnable,
- CORS limité aux domaines front autorisés,
- désactiver logs sensibles (mot de passe, token complet),
- messages d’erreur non verbeux en prod.

---

## 3. Exercices du jour

1. Écrire 4 tests sécurité minimum.
2. Externaliser secret JWT.
3. Configurer CORS proprement.
4. Vérifier qu’aucune info sensible ne fuite dans les réponses.

---

## 4. Validation du jour

Tu as fini si :

- tes tests sécurité principaux sont verts,
- ta config est plus proche d’un contexte réel.

