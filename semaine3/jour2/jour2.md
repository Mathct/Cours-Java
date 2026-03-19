## Jour 2 – Entité JPA `Task`

Objectif : transformer ton modèle `Task` en entité persistée.

## Exemple

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

    private boolean done;
}
```

## À voir

- `@Entity`, `@Id`, `@GeneratedValue`
- `@Column` (nullabilité, taille)
- constructeur vide obligatoire + getters/setters

## Validation

- Au démarrage, la table `tasks` est créée.
- Les colonnes correspondent au modèle.

