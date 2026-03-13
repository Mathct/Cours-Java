## Jour 1 – Maven/Gradle et structure d’un projet Spring Boot

Objectif du jour : comprendre le rôle de l’outil de build (Maven/Gradle), la structure d’un projet Spring Boot, et créer un premier squelette de projet.

---

## 1. Rôle de Maven / Gradle

- Gérer les **dépendances** (comme `composer.json` ou `package.json`).
- Rassembler, compiler, packager ton code en une application exécutable (JAR).
- Centraliser la configuration du projet (version de Java, plugins…).

En pratique, pour Spring Boot tu verras surtout :

- **Maven** avec un fichier `pom.xml`, ou
- **Gradle** avec un fichier `build.gradle`.

Pour ce cours, on peut partir sur **Maven** (plus répandu dans la doc Spring).

---

## 2. Créer un projet Spring Boot avec Spring Initializr

Va sur `https://start.spring.io` (Spring Initializr) et configure :

- **Project** : Maven Project
- **Language** : Java
- **Spring Boot** : version stable proposée
- **Project Metadata** :
  - Group : `com.example` (ou ton nom de domaine inversé)
  - Artifact : `tasks-api` (par exemple)
- **Packaging** : Jar
- **Java** : 17 (ou la version de ton JDK)

Dans les dépendances, ajoute au minimum :

- `Spring Web`

Télécharge le projet généré et dézippe-le dans un dossier, par exemple :

- `Cours Java/semaine2/tasks-api`

Ouvre ce projet dans ton IDE.

---

## 3. Comprendre la structure du projet

Tu devrais voir quelque chose comme :

- `pom.xml` : configuration Maven (dépendances, plugins, version Java…)
- `src/main/java/.../TasksApiApplication.java` : classe principale avec `main`
- `src/main/resources/application.properties` : configuration de l’application
- Dossiers `test` pour les tests (qu’on utilisera plus tard)

Regarde particulièrement la classe principale générée :

```java
@SpringBootApplication
public class TasksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksApiApplication.class, args);
    }
}
```

Points importants :

- `@SpringBootApplication` : annotation qui active la configuration automatique de Spring Boot.
- `SpringApplication.run(...)` : démarre le serveur web embarqué (Tomcat par défaut).

---

## 4. Lancer l’application

Dans ton IDE (ou via Maven), lance l’application :

- Avec l’IDE : bouton `Run` sur la classe `TasksApiApplication`.
- Avec Maven dans un terminal à la racine du projet :

```bash
mvn spring-boot:run
```

Vérifie dans la console que l’application démarre sans erreur.

Par défaut, elle écoute sur `http://localhost:8080`.

Tu peux tester dans un navigateur ou avec `curl` :

```bash
curl http://localhost:8080
```

Tu devrais obtenir soit une page par défaut, soit une erreur 404 (normal, aucun endpoint défini pour l’instant).

---

## 5. Comprendre le `pom.xml` (vue rapide)

Ouvre `pom.xml` et repère :

- La section `<properties>` (version de Java, de Spring Boot, etc.).
- La section `<dependencies>` (liste des libs, par ex. `spring-boot-starter-web`).
- La section `<build>` (plugins, configuration du packaging).

Ne cherche pas à tout comprendre aujourd’hui : l’idée est juste de voir que :

- `spring-boot-starter-web` apporte tout ce qu’il faut pour faire du web/REST.
- Tu pourras ajouter plus tard d’autres starters (JPA, Security, etc.).

---

## 6. Exercices du jour

1. Générer le projet Spring Boot avec Spring Initializr (Maven + Spring Web).
2. Ouvrir le projet dans ton IDE et repérer :
   - la classe principale avec `@SpringBootApplication`,
   - le fichier `pom.xml`,
   - le dossier `resources`.
3. Lancer l’application (IDE ou `mvn spring-boot:run`).
4. Vérifier que le serveur écoute sur `http://localhost:8080`.

---

## 7. Validation du jour

À la fin du Jour 1 de la semaine 2, tu dois être capable de :

- générer un projet Spring Boot avec Spring Initializr ;
- lancer l’application via ton IDE ou Maven ;
- repérer le rôle de `pom.xml` et de la classe principale ;
- vérifier que le serveur tourne sur `localhost:8080`.

Le prochain jour, tu ajouteras ton **premier contrôleur REST** avec `@RestController` et un premier endpoint simple.

