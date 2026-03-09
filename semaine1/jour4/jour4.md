## Jour 4 – POO : héritage, interfaces, organisation

Objectif du jour : comprendre comment Java gère l’héritage (`extends`), les interfaces (`implements`), la notion d’`abstract`, et commencer à organiser ton code en packages.

---

## 1. Héritage avec `extends`

L’héritage permet de créer une classe **plus spécifique** à partir d’une classe de base.

Exemple simple :

```java
public class Animal {
    public void makeSound() {
        System.out.println("Un animal fait un bruit");
    }
}

public class Dog extends Animal {
    // Dog hérite de Animal
}
```

- `Dog` **hérite** de `Animal`.
- `Dog` possède automatiquement la méthode `makeSound()`.

Utilisation :

```java
Dog d = new Dog();
d.makeSound();  // "Un animal fait un bruit"
```

---

## 2. Constructeur et `super`

Quand tu as un constructeur dans la classe parente, tu peux appeler ce constructeur avec `super(...)`.

Exemple adapté pour `Task` :

```java
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;

    public Task(int id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    // getters, setters, printSummary()...
}

public class ImportantTask extends Task {
    private int priority;

    public ImportantTask(int id, String title, String description, boolean done, int priority) {
        super(id, title, description, done); // Appel au constructeur de Task
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
```

`super(...)` doit être le **premier** appel dans le constructeur de la classe enfant.

---

## 3. Interfaces et `implements`

Une interface définit un **contrat** : des méthodes que les classes doivent implémenter.

Exemple :

```java
public interface Identifiable {
    int getId();
}
```

Une classe peut implémenter cette interface :

```java
public class Task implements Identifiable {
    private int id;
    private String title;
    private String description;
    private boolean done;

    public Task(int id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    @Override
    public int getId() {
        return id;
    }

    // autres getters/setters/méthodes...
}
```

Points importants :

- `implements Identifiable` : la classe s’engage à fournir une implémentation de `getId()`.
- L’annotation `@Override` indique que la méthode **redéfinit** une méthode d’interface (ou de classe parente).

---

## 4. Classes abstraites (`abstract`)

Une classe abstraite est une classe qu’on **ne peut pas instancier directement**, souvent utilisée comme base pour d’autres classes.

Exemple :

```java
public abstract class BaseTask {
    private int id;

    public BaseTask(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Méthode abstraite : pas de corps ici
    public abstract void printSummary();
}
```

Une classe qui hérite doit implémenter la méthode abstraite :

```java
public class ConcreteTask extends BaseTask {

    public ConcreteTask(int id) {
        super(id);
    }

    @Override
    public void printSummary() {
        System.out.println("Task #" + getId());
    }
}
```

Tu peux voir ça comme un “modèle partiel” qu’on complète dans les classes enfants.

---

## 5. Organisation en packages

Pour préparer les projets plus gros (et Spring plus tard), on commence à organiser :

- `model` : classes métiers (`Task`, `ImportantTask`, etc.).
- `service` : classes qui contiennent de la logique (par ex. gestion de listes de tâches).
- plus tard : `controller`, etc.

Exemple de structure :

- `src/`
  - `model/`
    - `Task.java`
    - `ImportantTask.java`
    - `Identifiable.java`
  - `Main.java`

Dans les fichiers, il faudra déclarer le package en haut :

```java
package model;

public class Task {
    // ...
}
```

Et dans `Main.java` :

```java
import model.Task;
import model.ImportantTask;

public class Main {
    public static void main(String[] args) {
        Task t = new Task(1, "Titre", "Description", false);
    }
}
```

Ton IDE peut gérer beaucoup de choses automatiquement (création de packages, imports, etc.).

---

## 6. Exercices du jour

### Exercice 1 – Interface `Identifiable`

1. Créer une interface `Identifiable` avec la méthode :
   ```java
   public interface Identifiable {
       int getId();
   }
   ```
2. Faire en sorte que `Task` implémente `Identifiable`.
3. Vérifier que tu peux appeler `getId()` sur une instance de `Task`.

### Exercice 2 – Classe `ImportantTask`

1. Créer une classe `ImportantTask` qui étend `Task` :
   - champ supplémentaire `priority` (int),
   - constructeur complet (appelant `super(...)`),
   - getters/setters pour `priority`.
2. Dans `Main`, créer une `ImportantTask` et afficher :
   - son résumé (`printSummary()`),
   - sa priorité.

### Exercice 3 – Organisation en packages

1. Créer un package `model` et y déplacer :
   - `Task`,
   - `ImportantTask`,
   - `Identifiable`.
2. Adapter les `package` en haut des fichiers.
3. Adapter les `import` dans `Main`.

---

## 7. Validation du jour

À la fin du Jour 4, tu dois être capable de :

- utiliser `extends` pour créer une classe fille ;
- appeler un constructeur parent avec `super(...)` ;
- déclarer et implémenter une interface simple ;
- comprendre à quoi sert `abstract` (même sans l’utiliser partout) ;
- organiser ton code en **packages** (`model`, plus tard `service`, etc.).

Tu pourras ensuite passer au **Jour 5** (collections & génériques : `List`, `Map`, etc., avec tes `Task` comme objets manipulés).

