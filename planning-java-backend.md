## Planning d’apprentissage Java pour le backend

Tu as déjà une bonne base en PHP/Symfony et Node/React. Ce planning est pensé pour 5 semaines, avec environ 1–2 h par jour, pour arriver à un premier backend propre en Java/Spring Boot.

---

## Vue d’ensemble des semaines

- **Semaine 1** : Java “pur” pour développeur web (syntax + POO + collections + exceptions)
- **Semaine 2** : Outils & premier mini-REST sans base de données
- **Semaine 3** : Persistance avec Spring Data JPA (vraie base SQL)
- **Semaine 4** : API propre (DTO, validation, gestion d’erreurs, tests)
- **Semaine 5** : Authentification simple + consolidation (JWT / sécurité basique)

---

## Semaine 1 – Java “pur” pour développeur web

**Objectifs**

- Être à l’aise avec la **syntaxe Java** et la POO à la sauce Java.
- Savoir lire/écrire du code Java simple sans réfléchir à la syntaxe.

**À voir**

- **Syntaxe de base**
  - Types primitifs (`int`, `double`, `boolean`, etc.) et objets (`String`, classes).
  - Méthode `main`, `if / else`, `for`, `while`.
  - Notion de `null`.
- **POO Java**
  - `class`, `interface`, `extends`, `implements`.
  - Modificateurs: `public`, `private`, `protected`.
  - `final`, packages, organisation des fichiers.
- **Collections et génériques**
  - `List`, `Map`, `Set`.
  - Génériques simples: `List<String>`, `Map<String, Integer>`.
- **Exceptions**
  - `try / catch / finally`.
  - Exceptions vérifiées / non vérifiées (notion).
  - Créer une petite exception personnalisée.

**Mini-exercices**

- Reprendre 2–3 petits exercices que tu connais déjà en PHP ou JS (par exemple: mini todo-list en mémoire, calculatrice, traitement de texte simple) mais **en version console Java**.
- Utiliser au moins une `List` et une `Map` dans tes exercices.

---

## Semaine 2 – Outils & premier mini-REST sans base de données

**Objectifs**

- Savoir **créer et builder** un projet Java moderne.
- Lancer un **projet Spring Boot** et exposer une petite API REST en mémoire.

**À voir**

- **Outil de build** (Maven ou Gradle)
  - Structure d’un projet.
  - Gestion des dépendances.
  - Lancer l’application (`mvn spring-boot:run` ou équivalent).
- **Spring Boot – bases**
  - Créer un projet via Spring Initializr.
  - Organisation des packages (controller / service / model, etc.).
- **API REST simple**
  - `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`.
  - Utiliser une liste en mémoire comme “pseudo base de données”.

**Projet fil rouge – Version 1 (sans base de données)**

- Créer une API “Gestion de tâches” (ou un autre thème qui te motive) :
  - Endpoints minimum :
    - `GET /tasks` : liste des tâches.
    - `POST /tasks` : créer une tâche.
    - `GET /tasks/{id}` : récupérer une tâche.
    - `DELETE /tasks/{id}` : supprimer une tâche.
  - Stockage : simple `List` en mémoire, gérée dans un service.

---

## Semaine 3 – Persistance avec Spring Data JPA

**Objectifs**

- Comprendre comment faire le **lien entre entités Java et base SQL**.
- Sauvegarder réellement les données de ton projet fil rouge.

**À voir**

- **JPA / Hibernate**
  - Entités: `@Entity`, `@Id`, `@GeneratedValue`.
  - Champs simples (String, int, date, etc.).
  - Relations de base: `@OneToMany`, `@ManyToOne` (au moins en théorie).
- **Spring Data JPA**
  - Interfaces `CrudRepository` / `JpaRepository`.
  - Méthodes dérivées: `findByTitle`, `findByStatus`, etc.
- **Base de données**
  - Choix d’un SGBD (PostgreSQL ou MySQL/MariaDB).
  - Configuration de la connexion dans `application.properties` / `application.yml`.
- (Optionnel) **Migrations**
  - Découvrir rapidement Flyway ou Liquibase (juste le principe).

**Projet fil rouge – Version 2 (avec base de données)**

- Remplacer le stockage en mémoire par une **vraie base**.
- Mapper la classe `Task` en entité JPA.
- Utiliser un `TaskRepository` (Spring Data JPA) pour effectuer les opérations CRUD.
- Ajouter quelques champs:
  - Date de création.
  - Statut (à faire, en cours, terminé, par ex.).

---

## Semaine 4 – API propre : DTO, validation, gestion d’erreurs, tests

**Objectifs**

- Construire une **API “propre”** :
  - Séparer entités et objets exposés aux clients (DTO).
  - Valider les données en entrée.
  - Gérer les erreurs proprement.
  - Commencer les tests.

**À voir**

- **DTO (Data Transfer Objects)**
  - Créer des classes dédiées pour les requêtes et les réponses.
  - Mapper entre DTO et entités (manuellement au début).
- **Validation**
  - `@Valid`, `@NotNull`, `@Size`, `@Email`, etc.
  - Gestion des messages d’erreur.
- **Gestion d’erreurs globale**
  - `@ControllerAdvice` et gestion centralisée des exceptions.
  - Retourner des réponses JSON propres avec un message, un code, etc.
- **Tests**
  - Tests unitaires avec JUnit 5.
  - (Optionnel) Tests d’intégration simples avec Spring Boot (tests d’API).

**Projet fil rouge – Version 3 (API “propre”)**

- Ajouter des DTO pour la création et la mise à jour de tâches.
- Ajouter la validation sur les endpoints (par exemple: titre non vide, longueur max).
- Mettre en place un handler global pour transformer les exceptions en réponses JSON claires.
- Écrire quelques tests:
  - Au moins 1–2 tests sur la couche service.
  - Idéalement, un test d’API (controller) avec Spring Boot Test.

---

## Semaine 5 – Authentification simple + consolidation

**Objectifs**

- Protéger ton API avec une **authentification simple** (par exemple JWT).
- Consolider tout ce que tu as vu, nettoyer ton projet, et le packager.

**À voir**

- **Notions de base Spring Security**
  - Filtre de sécurité.
  - `SecurityFilterChain` et configuration Java.
- **Auth simple**
  - Authentification par JWT ou session.
  - Endpoint de login (`POST /auth/login`) qui renvoie un token ou une session.
  - Protéger les endpoints `/tasks` pour qu’ils ne soient accessibles qu’aux utilisateurs authentifiés.
- **Packaging**
  - Construire un JAR exécutable.
  - Lancer l’appli en ligne de commande (comme si elle était en prod locale).
- (Optionnel) **Lambdas / Streams / Optional**
  - Aperçu rapide pour écrire du code plus idiomatique Java 8+.

**Projet fil rouge – Version finale**

- Ajouter une entité `User` et les endpoints nécessaires (inscription simple ou préchargement d’utilisateurs).
- Ajouter un endpoint `POST /auth/login` qui renvoie un token (JWT par exemple).
- Configurer Spring Security pour:
  - Protéger les endpoints de tâches.
  - Associer les tâches à l’utilisateur connecté (optionnel mais formateur).
- Construire le JAR final et lancer l’application comme un vrai service backend.

---

## Suite possible après ces 5 semaines

- **Approfondir Java**
  - Streams, lambdas, `Optional`.
  - Concurrence de base (`Thread`, `ExecutorService`, `CompletableFuture`).
- **Approfondir Spring**
  - Spring Security avancé (rôles, autorités, filtres personnalisés).
  - Tests d’intégration plus poussés.
- **Architecture**
  - Découvrir progressivement clean architecture, hexagonal, DDD.

