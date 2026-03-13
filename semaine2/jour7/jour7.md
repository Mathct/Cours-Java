## Jour 7 – Mini-projet API REST “Gestion de tâches” (version en mémoire)

Objectif du jour : consolider tout ce que tu as vu en semaine 2 en ayant une **API REST complète** pour gérer des tâches, stockées en mémoire.

---

## 1. Fonctionnalités attendues

Endpoints sur `/tasks` :

- `GET /tasks` : liste toutes les tâches.
- `GET /tasks/{id}` : récupère une tâche par id.
- `POST /tasks` : crée une tâche.
- `PUT /tasks/{id}` : met à jour une tâche.
- `DELETE /tasks/{id}` : supprime une tâche.

Bonus :

- validation (`@Valid` + annotations) sur les DTO ;
- codes HTTP corrects (201, 200, 204, 400, 404) ;
- messages d’erreur JSON raisonnablement clairs.

---

## 2. Checklist technique

- **Modèle** : classe `Task` (id, title, description, done).
- **DTOs** :
  - `CreateTaskRequest` ;
  - `UpdateTaskRequest` (ou réutiliser le même DTO avec champs optionnels).
- **Service** : `TaskService` avec :
  - stockage interne en `List<Task>` ;
  - `getAllTasks()`, `getTaskById(int id)`, `addTask(...)`, `updateTask(...)`, `deleteTask(int id)`.
- **Contrôleur** : `TaskController` avec les endpoints ci-dessus.
- **Validation** : `@Valid` + `@NotBlank`, `@Size` sur les DTOs.
- (Optionnel) **Erreur globale** : `GlobalExceptionHandler` avec `@ControllerAdvice`.

---

## 3. Scénario de test minimal

1. **Lister les tâches** (données de démo créées dans le constructeur de `TaskService`).
   - `GET /tasks`
2. **Créer une nouvelle tâche**.
   - `POST /tasks` avec un JSON valide ;
   - vérifier que le code HTTP est 201 ou 200 ;
   - relancer `GET /tasks` pour voir la nouvelle entrée.
3. **Récupérer une tâche par id**.
   - `GET /tasks/{id}` avec un id existant → 200 ;
   - avec un id inexistant → 404.
4. **Mettre à jour une tâche**.
   - `PUT /tasks/{id}` pour modifier le titre ou marquer `done=true` ;
   - vérifier le corps de la réponse et que `GET /tasks/{id}` renvoie bien la mise à jour.
5. **Supprimer une tâche**.
   - `DELETE /tasks/{id}` → 204 ;
   - vérifier avec `GET /tasks/{id}` que tu as bien un 404.
6. **Validation**.
   - `POST /tasks` sans `title` ou avec un titre vide → 400 ;
   - vérifier le format des erreurs.

---

## 4. Idées d’amélioration (si tu as du temps)

- Ajouter un champ `createdAt` (date de création) dans `Task`.
- Ajouter un filtre `GET /tasks?done=true|false`.
- Ajouter un champ `priority` et un tri par priorité côté service.
- Ajouter une pagination très simple : `GET /tasks?page=0&size=10` (même si tu la gères “à la main”).

---

## 5. Validation de fin de semaine 2

À la fin de la semaine 2, tu dois être capable de :

- créer un projet Spring Boot avec Maven ;
- structurer ton code en **controller / service / model / dto** ;
- exposer une **API REST CRUD** fonctionnelle en mémoire ;
- comprendre les bases de la validation et de la gestion d’erreurs dans Spring.

À partir de là, tu seras prêt pour la **Semaine 3** : brancher une **vraie base de données** via Spring Data JPA.

