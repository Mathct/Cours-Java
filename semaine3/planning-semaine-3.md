## Semaine 3 – Persistance avec Spring Data JPA

Objectif global : passer d’une API en mémoire à une API connectée à une vraie base SQL avec Spring Data JPA.

---

## Compétences visées en fin de semaine

- Configurer Spring Boot pour se connecter à PostgreSQL.
- Mapper des classes Java vers des tables SQL (`@Entity`, `@Id`, relations).
- Remplacer `List<Task>` par des repositories JPA.
- Écrire des requêtes simples, filtres, pagination et tri.
- Versionner le schéma de base avec Flyway.

---

## Plan détaillé

- **Jour 1** : préparation DB + dépendances JPA + configuration Spring.
- **Jour 2** : mapping de l’entité `Task` et cycle de vie JPA.
- **Jour 3** : `TaskRepository` + migration CRUD complète.
- **Jour 4** : relation `User`/`Task` et design des DTO pour éviter les boucles JSON.
- **Jour 5** : requêtes dérivées, pagination et tri.
- **Jour 6** : migrations Flyway + profils `dev`/`test`.
- **Jour 7** : mini-projet persistant final avec scénario de test complet.

---

## Livrable de fin de semaine

Une API tâches persistée en base qui supporte :

- CRUD complet,
- filtres (`done`, `keyword`),
- pagination,
- migrations versionnées,
- structure prête pour la semaine 4 (API propre + tests).

