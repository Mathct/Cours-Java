## Semaine 1 – Java “pur” pour développeur web

Objectif global : être capable d’écrire et de lire du Java “de base” (sans Spring) confortablement : syntaxe, POO, collections, exceptions.

---

## Jour 1 – Installation & premier contact avec Java

**Objectifs**

- Avoir un environnement prêt (JDK + IDE).
- Comprendre comment on exécute un programme Java.

**À faire**

- Installer un JDK (Java 17 ou version LTS actuelle).
- Installer un IDE :
  - IntelliJ IDEA Community (recommandé), ou
  - VS Code avec les extensions Java.
- Créer un projet simple “Hello World”.
- Comprendre rapidement :
  - `public class Main`
  - la méthode `public static void main(String[] args)`
  - compilation/exécution (bouton `Run` de l’IDE).

**Petit exercice**

- Écrire un programme qui affiche :
  - ton nom,
  - ton langage préféré,
  - une phrase sur ce que tu veux faire avec Java.

---

## Jour 2 – Syntaxe de base (variables, types, conditions, boucles, méthodes)

**Objectifs**

- Être à l’aise avec les types, les variables et le contrôle de flux.

**À voir**

- Types primitifs : `int`, `double`, `boolean`, `char`.
- Type `String`.
- Opérateurs : `+`, `-`, `*`, `/`, `%`, comparaisons (`==`, `!=`, `<`, `>`, etc.).
- Conditions : `if`, `else if`, `else`.
- Boucles : `for`, `while`.
- Méthodes :
  - mot-clé `static` au début pour simplifier,
  - paramètres, valeurs de retour.

**Exercices**

- Écrire une méthode qui calcule la **somme** de 1 à `n`.
- Écrire une méthode qui vérifie si un nombre est **pair**.
- Écrire une méthode qui **compte le nombre de voyelles** dans une `String`.

---

## Jour 3 – POO : classes et objets (version simple)

**Objectifs**

- Comprendre comment on déclare des classes et crée des objets en Java.

**À voir**

- Définir une classe simple (par exemple `User` ou `Task`).
- Champs (attributs) + constructeur.
- Getters / setters.
- Méthodes d’instance vs méthodes `static`.
- Différence entre classe et objet (`new`).

**Exercices**

- Créer une classe `Task` avec :
  - `id` (int),
  - `title` (String),
  - `description` (String),
  - `done` (boolean).
- Dans la méthode `main` :
  - créer plusieurs objets `Task`,
  - afficher leurs informations.
- Ajouter une méthode d’instance dans `Task` qui affiche un résumé lisible, par exemple : `[X] 1 - Titre de la tâche`.

---

## Jour 4 – POO : héritage, interfaces, organisation

**Objectifs**

- Voir comment Java gère l’héritage et les interfaces, sans trop de théorie.

**À voir**

- Héritage avec `extends`.
- Utilisation de `super` dans le constructeur.
- `interface` et `implements`.
- Notion de `abstract`.
- Packages : organiser ton code (par exemple `model`, `service`, etc.).

**Exercices**

- Créer une interface `Identifiable` avec une méthode `getId()`.
- Faire en sorte que `Task` implémente `Identifiable`.
- Créer une classe `ImportantTask` qui étend `Task` avec un champ supplémentaire `priority` (int ou enum).

---

## Jour 5 – Collections & génériques (focus List / Map)

**Objectifs**

- Savoir stocker et manipuler des listes d’objets.

**À voir**

- `List` avec `ArrayList`.
- Boucle `for` classique et boucle `for-each` : `for (Task t : tasks)`.
- `Map` avec `HashMap` (clé → valeur).
- Génériques : `List<Task>`, `Map<Integer, Task>`, etc.

**Exercices**

- Créer une `List<Task>` :
  - ajouter plusieurs tâches,
  - afficher toutes les tâches,
  - filtrer les tâches où `done == false`.
- Créer une `Map<Integer, Task>` indexée par `id` :
  - retrouver une tâche par ID,
  - supprimer une tâche par ID.

---

## Jour 6 – Exceptions & gestion d’erreurs

**Objectifs**

- Comprendre comment Java gère les erreurs et comment les propager.

**À voir**

- Bloc `try / catch / finally`.
- Lancer une exception : `throw new IllegalArgumentException("message");`
- Notion d’exceptions vérifiées / non vérifiées (sans trop de détails).
- Pourquoi on utilise beaucoup les exceptions dans le backend Java.

**Exercices**

- Créer une exception personnalisée `TaskNotFoundException` (qui étend `RuntimeException` par exemple).
- Écrire une méthode :
  - `Task findTaskById(int id, List<Task> tasks)` qui :
    - renvoie la tâche si trouvée,
    - sinon lance `TaskNotFoundException`.
- Appeler cette méthode depuis `main` avec un `try/catch` :
  - afficher un message propre si la tâche n’existe pas.

---

## Jour 7 – Mini-projet console “gestion de tâches”

**Objectifs**

- Réutiliser tout ce que tu as vu dans un **petit programme complet**.

**Idée de programme**

- Application console avec un menu simple :
  - `1` : lister les tâches
  - `2` : ajouter une tâche
  - `3` : marquer une tâche comme terminée
  - `4` : supprimer une tâche
  - `0` : quitter
- Utiliser :
  - une `List<Task>` comme stockage principal,
  - la méthode `findTaskById` (avec exception),
  - une boucle `while` pour afficher le menu et lire le choix utilisateur (avec `Scanner`).

**Résultat attendu en fin de semaine**

- Tu sais :
  - manipuler des classes et objets en Java,
  - utiliser `List` et `Map` avec des objets,
  - écrire et lire des méthodes avec paramètres et retours,
  - gérer une erreur simple avec une exception,
  - et surtout, tu ne bloques plus sur la **syntaxe Java de base**.

