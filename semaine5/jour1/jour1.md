## Jour 1 – Spring Security : bases

Objectif : activer la sécurité Spring et comprendre la chaîne de filtres.

## À faire

- Ajouter `spring-boot-starter-security`
- Définir `SecurityFilterChain`
- Autoriser temporairement :
  - `/auth/**`
  - éventuellement `/actuator/health`
- Protéger le reste

## Validation

- Endpoint protégé renvoie 401 sans auth.

