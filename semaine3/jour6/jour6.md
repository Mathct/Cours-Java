## Jour 6 – Migrations (Flyway) + profils

Objectif du jour : rendre ton schéma DB versionné et reproductible, puis séparer les configurations par environnement.

---

## 1. Ajouter Flyway

Dans `pom.xml` :

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

Créer le dossier :

- `src/main/resources/db/migration`

---

## 2. Créer les scripts de migration

Exemple `V1__create_users.sql` :

```sql
CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  email VARCHAR(150) NOT NULL UNIQUE,
  name VARCHAR(100) NOT NULL
);
```

Exemple `V2__create_tasks.sql` :

```sql
CREATE TABLE tasks (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(500),
  done BOOLEAN NOT NULL DEFAULT FALSE,
  owner_id BIGINT NOT NULL REFERENCES users(id)
);
```

---

## 3. Gérer les profils d’environnement

Créer :

- `application-dev.properties`
- `application-test.properties`

Utilité :

- `dev` : PostgreSQL local,
- `test` : config dédiée tests.

Lancer un profil :

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

---

## 4. Exercices du jour

1. Ajouter Flyway au projet.
2. Écrire `V1` et `V2`.
3. Réinitialiser DB et vérifier que Flyway reconstruit correctement.
4. Créer un profil `dev` distinct.

---

## 5. Validation du jour

Tu as fini si :

- ton schéma DB ne dépend plus de `ddl-auto=update`,
- les migrations passent dans l’ordre à chaque démarrage propre,
- tu peux lancer l’app avec un profil spécifique.

