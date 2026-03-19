## Jour 1 – Préparer la persistance (BDD + dépendances)

Objectif : connecter ton projet Spring Boot à une base de données.

## À faire

- Ajouter dans `pom.xml` :
  - `spring-boot-starter-data-jpa`
  - driver DB (`postgresql` recommandé)
- Configurer `application.properties` :

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tasks_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

- Créer la base `tasks_db`.

## Validation

- L’app démarre sans erreur DB.
- Hibernate se connecte et log les requêtes SQL.

