## Semaine 4 – API propre : DTO, validation, erreurs, tests

Objectif global : professionnaliser ton backend avec une API claire, validée, testée et facile à maintenir.

---

## Compétences visées

- Construire des DTO request/response propres.
- Mettre en place une validation cohérente.
- Uniformiser les erreurs HTTP/JSON.
- Séparer nettement controller / service / repository.
- Écrire des tests unitaires et des tests d’intégration.

---

## Plan détaillé

- **Jour 1** : DTO + mapping.
- **Jour 2** : validation Bean Validation avancée.
- **Jour 3** : gestion d’erreurs globale (`@ControllerAdvice`).
- **Jour 4** : exceptions métier et services propres.
- **Jour 5** : tests unitaires JUnit + Mockito.
- **Jour 6** : tests d’intégration API (`MockMvc`).
- **Jour 7** : mini-projet API “clean” consolidé.

---

## Livrable de fin de semaine

Une API persistée qui :

- n’expose pas directement ses entités JPA,
- valide toutes les entrées,
- renvoie des erreurs standardisées,
- possède une base de tests automatisés.

