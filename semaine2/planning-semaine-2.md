## Semaine 2 – Outils & premier mini-REST sans base de données

Objectif global : savoir créer et builder un projet Spring Boot avec Maven/Gradle et exposer une première API REST “propre” en mémoire (sans base de données).

---

## Vue d’ensemble de la semaine 2

- **Jour 1** : Maven (ou Gradle) et structure d’un projet Spring Boot
- **Jour 2** : Démarrer un projet Spring Boot + premier `@RestController`
- **Jour 3** : Endpoints GET (liste + détail), path params, query params
- **Jour 4** : Endpoints POST (création), stockage en mémoire (`List`), début de séparation `controller` / `service`
- **Jour 5** : PUT/DELETE, codes HTTP, réponses JSON “propres” (`ResponseEntity`)
- **Jour 6** : Améliorations : validation simple + gestion d’erreurs de base
- **Jour 7** : Mini-projet API “Gestion de tâches” en mémoire (version complète)

Projet fil rouge : **API REST “Gestion de tâches”** qui manipule des tâches stockées dans une simple `List` côté serveur (service Spring).

