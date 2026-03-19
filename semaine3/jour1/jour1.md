## Jour 1 – Préparer la persistance (BDD + dépendances)

Objectif du jour : connecter ton projet Spring Boot à PostgreSQL et vérifier que l’application démarre correctement avec JPA activé.

---

## 1. Installer et préparer PostgreSQL

- Vérifier que PostgreSQL tourne localement.
- Créer une base dédiée au projet, par exemple `tasks_db`.
- Créer (ou utiliser) un utilisateur avec droits sur cette base.

Exemple SQL rapide :

```sql
CREATE DATABASE tasks_db;
```

---

## 2. Ajouter les dépendances Maven

Dans `pom.xml`, ajouter au minimum :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

Rappel :

- `spring-boot-starter-data-jpa` apporte Spring Data JPA + Hibernate.
- le driver PostgreSQL permet la connexion JDBC réelle.

---

## 3. Configurer `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tasks_db
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Conseil :

- `ddl-auto=update` est pratique en apprentissage.
- en projet réel, on préférera Flyway/Liquibase (vu plus tard dans la semaine).

---

## 4. Vérifier le démarrage

Lancer l’application et confirmer :

- pas d’erreur de connexion DB,
- logs Hibernate visibles,
- serveur HTTP opérationnel.

Si erreur :

- vérifier host/port de PostgreSQL,
- vérifier username/password,
- vérifier que la base existe bien.

---

## 5. Exercices du jour

1. Ajouter les 2 dépendances JPA + PostgreSQL.
2. Configurer `application.properties`.
3. Démarrer l’application et corriger les erreurs éventuelles.
4. Prendre une capture ou une note des logs de démarrage JPA.

---

## 6. Validation du jour

À la fin du Jour 1, tu dois pouvoir dire :

- “Mon app Spring Boot est connectée à PostgreSQL.”
- “JPA/Hibernate est activé et prêt à persister mes entités.”

