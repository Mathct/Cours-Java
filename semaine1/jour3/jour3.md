## Jour 3 – POO : classes et objets (version simple)

Objectif du jour : comprendre comment déclarer des classes, créer des objets, utiliser un constructeur, des getters/setters et des méthodes d’instance en Java.

---

## 1. Rappel : structure d’un programme avec plusieurs méthodes

On part sur une classe principale (par exemple `Main`) qui va utiliser une autre classe (par exemple `Task`).

Exemple minimal :

```java
public class Main {
    public static void main(String[] args) {
        // On utilisera ici la classe Task
    }
}
```

L’idée du jour : créer une **classe métier** (`Task`) dans son propre fichier, et la manipuler depuis `Main`.

---

## 2. Créer une classe simple : `Task`

### 2.1. Fichier `Task.java`

Dans ton projet de `jour3`, crée un fichier `Task.java` avec une structure de base :

```java
public class Task {
    int id;
    String title;
    String description;
    boolean done;
}
```

Pour l’instant, les champs peuvent être sans `private` pour simplifier, mais l’objectif sera de passer rapidement en `private` + getters/setters.

---

## 3. Constructeur

Un constructeur permet d’initialiser l’objet au moment du `new`.

Exemple :

```java
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;

    // Constructeur
    public Task(int id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }
}
```

Points importants :

- `public Task(...)` : le nom du constructeur est le **même** que le nom de la classe.
- `this.id = id;` : `this` fait référence au champ de l’objet courant.

---

## 4. Getters et setters

En Java, on accède aux champs via des méthodes dédiées (encapsulation).

Exemple :

```java
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}
```

Fais la même chose pour `description` et `done`.

> Tu peux les générer automatiquement avec ton IDE (clic droit → Generate / Code → Generate → Getters and Setters).

---

## 5. Méthode d’instance : afficher un résumé

Ajoute une méthode dans `Task` qui affiche un résumé lisible :

```java
public void printSummary() {
    String status = done ? "[X]" : "[ ]";
    System.out.println(status + " " + id + " - " + title);
}
```

Ici :

- `done ? "[X]" : "[ ]"` utilise l’opérateur ternaire (`condition ? siVrai : siFaux`).
- La méthode ne retourne rien (`void`), elle **affiche** directement.

Tu peux aussi ajouter une méthode `toString()` plus tard, mais pour aujourd’hui `printSummary()` suffit.

---

## 6. Utiliser la classe `Task` dans `Main`

Dans `Main.java` :

```java
public class Main {
    public static void main(String[] args) {
        Task t1 = new Task(1, "Apprendre Java", "Suivre le cours de la semaine 1", false);
        Task t2 = new Task(2, "Faire les exercices", "Jour 3 : classes et objets", false);

        t1.printSummary();
        t2.printSummary();

        // Modifier une tâche
        t1.setDone(true);
        t1.setTitle("Apprendre Java (POO)");

        t1.printSummary();
    }
}
```

Objectifs :

- Comprendre le `new Task(...)` (instanciation).
- Voir la différence entre la **classe** (`Task`) et ses **instances** (`t1`, `t2`).

---

## 7. Différence méthodes `static` vs méthodes d’instance

- Méthodes `static` : appartiennent à la **classe**.
  - Appel : `MaClasse.maMethodeStatique()`.
  - Exemple : `Math.max(a, b)`.
- Méthodes d’instance : appartiennent à **l’objet**.
  - Appel : `monObjet.maMethode()`.

Ici, `printSummary()` est une méthode d’instance :

- Il faut un **objet** (`Task t1 = new Task(...);`) pour l’appeler.
- Tu ne peux pas faire `Task.printSummary();` directement, car il manque l’instance.

---

## 8. Exercices du jour

### Exercice 1 – Classe `Task` complète

1. Créer la classe `Task` avec :
   - `id` (int),
   - `title` (String),
   - `description` (String),
   - `done` (boolean).
2. Mettre les champs en `private`.
3. Ajouter :
   - un constructeur prenant les 4 valeurs,
   - les getters/setters pour chaque champ,
   - la méthode `printSummary()` vue plus haut.

### Exercice 2 – Créer et afficher plusieurs tâches

Dans `Main` :

- Créer au moins **3 objets** `Task` différents.
- Les afficher avec `printSummary()`.
- Modifier quelques propriétés (par exemple marquer une tâche comme faite) via des setters, puis réafficher.

### Exercice 3 – Méthode pour “terminer” une tâche

Ajoute dans `Task` une méthode :

```java
public void markAsDone() {
    this.done = true;
}
```

Puis :

- Depuis `Main`, appeler `markAsDone()` sur une tâche,
- Appeler `printSummary()` avant et après pour voir la différence.

---

## 9. Validation du jour

À la fin du Jour 3, tu dois être capable de :

- créer une nouvelle classe Java dans son propre fichier ;
- déclarer des champs, un constructeur, des getters/setters ;
- comprendre et utiliser `new` pour instancier un objet ;
- appeler des méthodes d’instance sur tes objets ;
- gérer un petit “modèle” (`Task`) que tu réutiliseras les jours suivants.

Ensuite, tu pourras passer au **Jour 4** (héritage, interfaces, organisation en packages).

