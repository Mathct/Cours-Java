## Jour 6 – Exceptions & gestion d’erreurs

Objectif du jour : comprendre comment Java gère les erreurs avec les exceptions (`try / catch / finally`, `throw`) et créer ta propre exception `TaskNotFoundException` pour rendre la manipulation de tâches plus sûre.

---

## 1. Pourquoi des exceptions ?

En Java, au lieu de renvoyer des codes d’erreur (comme `-1` ou `null` partout), on utilise **les exceptions** pour signaler les problèmes.

Exemples de cas où une exception est utile :

- tâche non trouvée,
- paramètre invalide (id négatif, titre vide, etc.),
- problème d’accès à une ressource (fichier, base de données…).

---

## 2. `try / catch / finally`

Structure de base :

```java
try {
    // Code qui peut lancer une exception
} catch (ExceptionType e) {
    // Réaction si ExceptionType est lancée
} finally {
    // (optionnel) Code exécuté dans tous les cas
}
```

Exemple simple :

```java
try {
    int result = 10 / 0; // Division par zéro -> ArithmeticException
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("Erreur de calcul : " + e.getMessage());
}
```

Le bloc `finally` est souvent utilisé pour **libérer des ressources** (fermer un fichier, une connexion, etc.).

---

## 3. Lancer une exception : `throw`

Tu peux décider de **lancer toi-même** une exception lorsque tu détectes une situation anormale.

Exemple :

```java
public static void verifierAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("L'âge ne peut pas être négatif");
    }
}
```

Appel :

```java
try {
    verifierAge(-5);
} catch (IllegalArgumentException e) {
    System.out.println("Problème : " + e.getMessage());
}
```

---

## 4. Créer une exception personnalisée : `TaskNotFoundException`

On va créer une exception spécifique quand une tâche n’est pas trouvée.

### 4.1. Classe de l’exception

Dans un fichier `TaskNotFoundException.java` (par exemple dans le package `model` ou `exception`) :

```java
public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String message) {
        super(message);
    }
}
```

Ici, on étend `RuntimeException` (exception non vérifiée) pour simplifier.

---

## 5. Méthode `findTaskById` avec exception

On va écrire une méthode qui cherche une tâche par `id` dans une `List<Task>`.  
Si la tâche n’existe pas, elle lance `TaskNotFoundException`.

Exemple :

```java
import java.util.List;

public class TaskUtils {

    public static Task findTaskById(int id, List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task avec id " + id + " non trouvée");
    }
}
```

Tu peux également mettre cette méthode dans un `TaskService` si tu l’as créé.

---

## 6. Utiliser `findTaskById` avec `try/catch`

Dans `Main` :

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Apprendre Java", "Jour 6 : exceptions", false));
        tasks.add(new Task(2, "Faire les exercices", "Jour 6", false));

        try {
            Task t = TaskUtils.findTaskById(3, tasks); // id qui n'existe pas
            t.printSummary();
        } catch (TaskNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
```

Résultat attendu :

- si l’id existe → tâche affichée ;
- si l’id n’existe pas → message d’erreur propre.

---

## 7. Exercices du jour

### Exercice 1 – `TaskNotFoundException`

1. Créer la classe `TaskNotFoundException` qui étend `RuntimeException`.
2. Ajouter un constructeur qui prend un `String message` et l’envoie au parent.

### Exercice 2 – `findTaskById` sur une `List<Task>`

1. Créer une méthode statique :
   ```java
   public static Task findTaskById(int id, List<Task> tasks) {
       // ...
   }
   ```
2. Si la tâche est trouvée, la renvoyer.
3. Sinon, lancer `new TaskNotFoundException("...")`.
4. Dans `main`, entourer l’appel dans un `try/catch` et afficher un message clair.

### Exercice 3 – Variante avec `Map<Integer, Task>` (optionnel)

1. Si tu as une `Map<Integer, Task>`, écrire :
   ```java
   public static Task findTaskByIdInMap(int id, Map<Integer, Task> map) {
       Task task = map.get(id);
       if (task == null) {
           throw new TaskNotFoundException("Task avec id " + id + " non trouvée dans la map");
       }
       return task;
   }
   ```
2. Tester cette méthode dans `main` avec des id existants et inexistants.

---

## 8. Bonus : `finally` (optionnel)

Tu peux tester un exemple avec `finally` :

```java
try {
    System.out.println("Avant exception");
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Dans catch : " + e.getMessage());
} finally {
    System.out.println("Dans finally (toujours exécuté)");
}
```

Observe l’ordre d’affichage.

---

## 9. Validation du jour

À la fin du Jour 6, tu dois être capable de :

- comprendre et utiliser `try / catch` pour intercepter une erreur ;
- lancer une exception dans ton propre code avec `throw` ;
- créer une exception personnalisée (`TaskNotFoundException`) ;
- écrire une méthode `findTaskById` qui :
  - renvoie la tâche si elle existe ;
  - lance une exception claire sinon.

Tu es maintenant prêt pour le **Jour 7**, où tu vas assembler tout ça dans un **mini-projet console de gestion de tâches**.

