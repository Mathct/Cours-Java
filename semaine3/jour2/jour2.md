## Jour 2 – Entité JPA `Task`

Objectif du jour : mapper correctement ton modèle `Task` en entité JPA persistée dans PostgreSQL.

---

## 1. Créer l’entité `Task`

```java
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private boolean done = false;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.done = false;
    }

    // getters/setters
}
```

---

## 2. Comprendre les annotations importantes

- `@Entity` : classe gérée par JPA.
- `@Table(name = "tasks")` : nom SQL de la table.
- `@Id` : clé primaire.
- `@GeneratedValue(strategy = IDENTITY)` : ID auto-incrément côté DB.
- `@Column` : contraintes SQL (taille, nullabilité...).

---

## 3. Bonnes pratiques à ce stade

- Garder un **constructeur vide** (requis par JPA).
- Éviter une logique métier complexe dans l’entité (on privilégie le service).
- Utiliser `Long` pour les IDs côté Java backend.

---

## 4. Vérifier la génération de la table

Au redémarrage de l’application :

- Hibernate doit créer (ou mettre à jour) la table `tasks`.
- Vérifier dans la DB que les colonnes sont bien là (`id`, `title`, `description`, `done`).

---

## 5. Exercices du jour

1. Mapper `Task` avec les annotations JPA.
2. Ajouter les contraintes `nullable`/`length`.
3. Ajouter un constructeur vide + constructeur pratique.
4. Vérifier en base la structure générée.

---

## 6. Validation du jour

Tu as terminé si :

- la table `tasks` existe en base,
- son schéma reflète ton entité Java,
- l’application démarre sans erreur de mapping.

