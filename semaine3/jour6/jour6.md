## Jour 6 – Migrations (Flyway) + profils

Objectif : fiabiliser la DB avec des scripts versionnés.

## Flyway

- Ajouter dépendance `flyway-core`
- Créer `src/main/resources/db/migration/V1__init.sql`

Exemple :

```sql
CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  email VARCHAR(150) NOT NULL UNIQUE,
  name VARCHAR(100) NOT NULL
);
```

Puis `V2__tasks.sql` pour `tasks`.

## Profils

- `application-dev.properties`
- `application-test.properties`

Lancer avec :

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Validation

- Les scripts Flyway passent au démarrage.
- La structure DB est reproductible.

