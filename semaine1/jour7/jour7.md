## Jour 7 – Mini-projet console “gestion de tâches”

Objectif du jour : réutiliser tout ce que tu as vu (POO, listes, maps, exceptions) pour construire une petite application console complète de gestion de tâches.

---

## 1. Objectif fonctionnel

Créer un programme console avec un **menu** permettant de :

- `1` : lister les tâches
- `2` : ajouter une tâche
- `3` : marquer une tâche comme terminée
- `4` : supprimer une tâche
- `0` : quitter

Stockage :

- utiliser une `List<Task>` comme stockage principal ;
- tu peux éventuellement garder aussi une `Map<Integer, Task>` si tu veux un accès rapide par id.

---

## 2. Structure suggérée du projet

Tu peux organiser ton code ainsi :

- `model/`
  - `Task.java`
  - `ImportantTask.java` (optionnel)
  - `Identifiable.java` (optionnel)
  - `TaskNotFoundException.java`
- `service/`
  - `TaskService.java`
- `Main.java`

Ce n’est pas obligatoire, mais cela prépare bien pour Spring plus tard (model/service/controller).

---

## 3. Classe `TaskService`

Exemple de squelette :

```java
package service;

import model.Task;
import model.TaskNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(String title, String description) {
        Task task = new Task(nextId, title, description, false);
        tasks.add(task);
        nextId++;
        return task;
    }

    public Task findById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task avec id " + id + " non trouvée");
    }

    public void markAsDone(int id) {
        Task task = findById(id);
        task.setDone(true);
    }

    public void deleteById(int id) {
        Task task = findById(id);
        tasks.remove(task);
    }
}
```

Adapte le code selon ce que tu as fait les jours précédents (package, constructeur, etc.).

---

## 4. Lire les entrées utilisateur avec `Scanner`

Dans `Main`, on utilisera `Scanner` pour lire depuis la console :

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();
        System.out.println("Bonjour, " + nom);

        scanner.close();
    }
}
```

Pour le menu, on gardera le `Scanner` ouvert pendant toute la durée du programme.

---

## 5. Boucle de menu principale

Exemple de squelette dans `Main` :

```java
import model.TaskNotFoundException;
import service.TaskService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        boolean running = true;

        while (running) {
            afficherMenu();
            System.out.print(\"Votre choix : \");
            String input = scanner.nextLine();

            switch (input) {
                case \"1\":
                    listerTaches(taskService);
                    break;
                case \"2\":
                    ajouterTache(scanner, taskService);
                    break;
                case \"3\":
                    marquerTacheTerminee(scanner, taskService);
                    break;
                case \"4\":
                    supprimerTache(scanner, taskService);
                    break;
                case \"0\":
                    running = false;
                    System.out.println(\"Au revoir !\");
                    break;
                default:
                    System.out.println(\"Choix invalide. Merci de réessayer.\");
            }
        }

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println(\"============================\");
        System.out.println(\"   Gestion de tâches (console)\");
        System.out.println(\"============================\");
        System.out.println(\"1. Lister les tâches\");
        System.out.println(\"2. Ajouter une tâche\");
        System.out.println(\"3. Marquer une tâche comme terminée\");
        System.out.println(\"4. Supprimer une tâche\");
        System.out.println(\"0. Quitter\");
    }

    // Méthodes à implémenter plus bas...
}
```

---

## 6. Implémenter les actions du menu

### 6.1. Lister les tâches

```java
private static void listerTaches(TaskService taskService) {
    if (taskService.getAllTasks().isEmpty()) {
        System.out.println(\"Aucune tâche pour le moment.\");
        return;
    }

    System.out.println(\"Liste des tâches :\");
    for (Task task : taskService.getAllTasks()) {
        task.printSummary();
    }
}
```

### 6.2. Ajouter une tâche

```java
private static void ajouterTache(Scanner scanner, TaskService taskService) {
    System.out.print(\"Titre : \");
    String title = scanner.nextLine();

    System.out.print(\"Description : \");
    String description = scanner.nextLine();

    Task task = taskService.addTask(title, description);
    System.out.println(\"Tâche ajoutée :\");
    task.printSummary();
}
```

### 6.3. Marquer une tâche comme terminée

```java
private static void marquerTacheTerminee(Scanner scanner, TaskService taskService) {
    System.out.print(\"Id de la tâche à terminer : \");
    String input = scanner.nextLine();

    try {
        int id = Integer.parseInt(input);
        taskService.markAsDone(id);
        System.out.println(\"Tâche \" + id + \" marquée comme terminée.\");
    } catch (NumberFormatException e) {
        System.out.println(\"Id invalide (ce n'est pas un nombre).\");
    } catch (TaskNotFoundException e) {
        System.out.println(\"Erreur : \" + e.getMessage());
    }
}
```

### 6.4. Supprimer une tâche

```java
private static void supprimerTache(Scanner scanner, TaskService taskService) {
    System.out.print(\"Id de la tâche à supprimer : \");
    String input = scanner.nextLine();

    try {
        int id = Integer.parseInt(input);
        taskService.deleteById(id);
        System.out.println(\"Tâche \" + id + \" supprimée.\");
    } catch (NumberFormatException e) {
        System.out.println(\"Id invalide (ce n'est pas un nombre).\");
    } catch (TaskNotFoundException e) {
        System.out.println(\"Erreur : \" + e.getMessage());
    }
}
```

---

## 7. Exercices / améliorations possibles

- Ajouter un champ `dueDate` (date limite) dans `Task` (pour l’instant en `String`).
- Ajouter une option de menu pour :
  - modifier le titre ou la description d’une tâche ;
  - filtrer les tâches terminées / non terminées ;
  - afficher seulement les tâches importantes (`ImportantTask` avec priorité élevée).
- Améliorer l’affichage (par exemple en numérotant les lignes, en ajoutant des séparateurs).

---

## 8. Validation de fin de semaine 1

À la fin du Jour 7 (et de la Semaine 1), tu dois être capable de :

- créer et organiser plusieurs classes (`Task`, `TaskService`, `TaskNotFoundException`, éventuellement `ImportantTask`) ;
- utiliser `List<Task>` pour stocker et parcourir des objets ;
- lancer et intercepter des exceptions personnalisées ;
- construire une petite application console interactive avec un menu et des entrées utilisateur ;
- comprendre globalement comment tu pourrais **remplacer plus tard la console par une API REST** (les actions du menu deviendront des endpoints).

Tu seras alors prêt à attaquer la **Semaine 2** : outils de build (Maven/Gradle) et **premier mini-REST avec Spring Boot**.

