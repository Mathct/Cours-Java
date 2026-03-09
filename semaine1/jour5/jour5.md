## Jour 5 – Collections & génériques (focus List / Map)

Objectif du jour : savoir stocker et manipuler des listes d’objets (`List<Task>`) et des maps (`Map<Integer, Task>`), avec les bases des génériques.

---

## 1. Tableaux vs collections

En Java, tu as :

- **Tableaux** : taille fixe, syntaxe comme `int[]`, `Task[]`.
- **Collections** : taille dynamique, beaucoup de méthodes utilitaires.

Pour le backend moderne, on utilise surtout les **collections**, en particulier :

- `List` (liste ordonnée, doublons possibles),
- `Set` (ensemble sans doublons),
- `Map` (clé → valeur).

Aujourd’hui, on se concentre sur **`List`** et **`Map`**.

---

## 2. `List` avec `ArrayList`

Tu dois importer :

```java
import java.util.List;
import java.util.ArrayList;
```

### 2.1. Créer une liste

```java
List<String> noms = new ArrayList<>();
noms.add("Alice");
noms.add("Bob");
noms.add("Charlie");
```

### 2.2. Parcourir une liste

```java
for (int i = 0; i < noms.size(); i++) {
    System.out.println(noms.get(i));
}

// Variante : for-each
for (String nom : noms) {
    System.out.println(nom);
}
```

### 2.3. Liste de `Task`

```java
List<Task> tasks = new ArrayList<>();
tasks.add(new Task(1, "Apprendre Java", "Semaine 1", false));
tasks.add(new Task(2, "Faire les exercices", "Jour 5 : collections", false));

for (Task t : tasks) {
    t.printSummary();
}
```

---

## 3. Génériques : `List<Task>`, `Map<Integer, Task>`

Les `< >` indiquent le **type d’élément** dans la collection.

- `List<String>` : liste de `String`.
- `List<Task>` : liste de `Task`.
- `Map<Integer, Task>` : map qui associe un `Integer` à une `Task`.

Cela permet au compilateur de vérifier les types et d’éviter les cast partout.

---

## 4. `Map` avec `HashMap`

Tu dois importer :

```java
import java.util.Map;
import java.util.HashMap;
```

### 4.1. Créer une map

```java
Map<Integer, String> pays = new HashMap<>();
pays.put(33, "France");
pays.put(34, "Espagne");

String valeur = pays.get(33); // "France"
```

### 4.2. Map de `Task` indexée par `id`

```java
Map<Integer, Task> taskMap = new HashMap<>();

Task t1 = new Task(1, "Apprendre Java", "Semaine 1", false);
Task t2 = new Task(2, "Faire les exercices", "Jour 5 : collections", false);

taskMap.put(t1.getId(), t1);
taskMap.put(t2.getId(), t2);

Task task = taskMap.get(1);  // récupère la Task avec id 1
if (task != null) {
    task.printSummary();
}
```

### 4.3. Parcourir une `Map`

```java
for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
    Integer id = entry.getKey();
    Task task = entry.getValue();
    System.out.println("ID = " + id);
    task.printSummary();
}
```

---

## 5. Méthodes utilitaires possibles (préparation pour plus tard)

Tu peux déjà commencer à créer une petite classe de “service” pour gérer les tâches :

```java
import java.util.List;
import java.util.ArrayList;

public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
```

Ensuite dans `Main`, tu utiliseras `TaskService` au lieu de manipuler la liste directement.

---

## 6. Exercices du jour

### Exercice 1 – `List<Task>` de base

1. Dans `Main`, créer une `List<Task>` :
   ```java
   List<Task> tasks = new ArrayList<>();
   ```
2. Ajouter plusieurs tâches (au moins 3).
3. Parcourir la liste avec un `for-each` et appeler `printSummary()` pour chacune.

### Exercice 2 – Filtrer les tâches non terminées

1. Toujours avec ta `List<Task>`, écrire une méthode :
   ```java
   public static void printUndoneTasks(List<Task> tasks) {
       // ...
   }
   ```
2. Dans cette méthode :
   - parcourir la liste,
   - pour chaque tâche où `done == false`, afficher le résumé.
3. Appeler cette méthode depuis `main`.

### Exercice 3 – `Map<Integer, Task>` indexée par `id`

1. Créer une `Map<Integer, Task>` et y insérer tes tâches avec `put(task.getId(), task)`.
2. Écrire une méthode :
   ```java
   public static Task findTaskInMapById(int id, Map<Integer, Task> map) {
       return map.get(id);
   }
   ```
3. Tester dans `main` :
   - récupérer une tâche par son `id`,
   - afficher le résumé si elle existe.

### Exercice 4 (optionnel) – Service simple

1. Créer une classe `TaskService` avec :
   - un champ `List<Task> tasks`,
   - une méthode `addTask(Task task)`,
   - une méthode `List<Task> getAllTasks()`.
2. Dans `Main`, utiliser `TaskService` pour :
   - ajouter des tâches,
   - récupérer toutes les tâches et les afficher.

---

## 7. Validation du jour

À la fin du Jour 5, tu dois être capable de :

- créer et utiliser une `List<Task>` (ajout, parcours, filtrage) ;
- créer et utiliser une `Map<Integer, Task>` pour indexer les tâches par `id` ;
- comprendre l’intérêt des génériques (`List<Task>`, `Map<Integer, Task>`) ;
- voir comment commencer à structurer une logique métier dans un “service”.

Tu pourras ensuite passer au **Jour 6** (exceptions & gestion d’erreurs) pour rendre ton code plus robuste.

