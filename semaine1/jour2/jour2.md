## Jour 2 – Syntaxe de base (variables, types, conditions, boucles, méthodes)

Objectif du jour : être à l’aise avec les types, les variables, le contrôle de flux (conditions, boucles) et l’écriture de méthodes en Java.

---

## 1. Variables et types

### 1.1. Types primitifs

En Java, les types de base sont **déclarés explicitement** (contrairement à PHP/JS) :

| Type     | Description        | Exemple        |
|----------|--------------------|----------------|
| `int`    | Entier             | `42`           |
| `long`   | Grand entier       | `42L`          |
| `double` | Nombre décimal     | `3.14`         |
| `float`  | Décimal simple     | `3.14f`        |
| `boolean`| Vrai / faux        | `true`, `false`|
| `char`   | Un caractère       | `'A'`          |

Exemple :

```java
int age = 25;
double prix = 19.99;
boolean estActif = true;
char grade = 'A';
```

### 1.2. Type `String`

`String` est une **classe** (pas un type primitif), donc on utilise des guillemets doubles :

```java
String nom = "Alice";
String phrase = "Bonjour, " + nom;  // concaténation avec +
```

Quelques méthodes utiles : `length()`, `toLowerCase()`, `toUpperCase()`, `charAt(i)`, `substring(debut, fin)`.

---

## 2. Opérateurs

- **Arithmétiques** : `+`, `-`, `*`, `/`, `%` (modulo).
- **Comparaison** : `==`, `!=`, `<`, `>`, `<=`, `>=`.
- **Logiques** : `&&` (et), `||` (ou), `!` (non).
- **Attention** : pour comparer deux `String`, utilise `s1.equals(s2)` et non `s1 == s2`.

Exemple :

```java
int a = 10;
int b = 3;
System.out.println(a / b);   // 3 (division entière)
System.out.println(a % b);   // 1 (reste)

String x = "hello";
String y = "hello";
System.out.println(x.equals(y));  // true
```

---

## 3. Conditions : `if` / `else if` / `else`

Même logique qu’en PHP/JS, avec des **accolades obligatoires** et une condition entre parenthèses :

```java
int note = 14;

if (note >= 16) {
    System.out.println("Très bien");
} else if (note >= 10) {
    System.out.println("Admis");
} else {
    System.out.println("Échec");
}
```

---

## 4. Boucles

### 4.1. Boucle `for`

```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

### 4.2. Boucle `while`

```java
int j = 0;
while (j < 5) {
    System.out.println("j = " + j);
    j++;
}
```

### 4.3. Boucle `for-each` (pour parcourir une liste)

On la verra plus en détail avec les collections (Jour 5). Pour un tableau :

```java
int[] nombres = { 1, 2, 3, 4, 5 };
for (int n : nombres) {
    System.out.println(n);
}
```

---

## 5. Méthodes (fonctions)

Une méthode a une **signature** : type de retour, nom, paramètres.

- Pour l’instant on utilise `static` pour pouvoir l’appeler depuis `main` sans créer d’objet.

Syntaxe :

```java
public static typeRetour nomMethode(type1 param1, type2 param2) {
    // ...
    return valeur;  // si typeRetour n'est pas void
}
```

Exemples :

```java
// Sans retour (void)
public static void direBonjour(String prenom) {
    System.out.println("Bonjour, " + prenom);
}

// Avec retour
public static int doubler(int x) {
    return x * 2;
}

// Appel depuis main
public static void main(String[] args) {
    direBonjour("Alice");
    int resultat = doubler(5);  // 10
}
```

---

## 6. Squelette de classe pour les exercices

Tu peux partir de ce fichier (par exemple `Main.java` dans un projet `jour2`) :

```java
public class Main {

    public static void main(String[] args) {
        // Appels des exercices ici
    }

    // Tes méthodes ici
}
```

---

## 7. Exercices

### Exercice 1 – Somme de 1 à n

Écrire une méthode `somme(int n)` qui calcule la somme des entiers de 1 à `n` (inclus) et la renvoie.

- Exemple : `somme(5)` → `1 + 2 + 3 + 4 + 5` = `15`.
- Tester dans `main` : `System.out.println(somme(5));`

---

### Exercice 2 – Pair ou impair

Écrire une méthode `estPair(int n)` qui renvoie `true` si `n` est pair, `false` sinon.

- Indice : utiliser le modulo `n % 2`.
- Tester avec plusieurs valeurs dans `main`.

---

### Exercice 3 – Compter les voyelles

Écrire une méthode `compterVoyelles(String s)` qui renvoie le nombre de voyelles (a, e, i, o, u, y – sans se soucier des accents pour commencer) dans la chaîne `s`.

- Indice : parcourir la chaîne avec une boucle `for` et `charAt(i)`, ou comparer chaque caractère à une chaîne de voyelles.
- Exemple : `compterVoyelles("hello")` → 2.

---

## 8. Correction rapide (à faire après avoir essayé)

- **Somme** : boucle `for (int i = 1; i <= n; i++)` et accumuler dans une variable `total`.
- **Pair** : `return n % 2 == 0;`
- **Voyelles** : une variable `count`, boucle sur les indices, et pour chaque `s.charAt(i)` vérifier si c’est une voyelle (par ex. avec une condition `if` ou une chaîne `"aeiouy"` et `indexOf` / `contains`).

---

## 9. Validation du jour

À la fin du Jour 2, tu dois être capable de :

- déclarer des variables avec les types `int`, `double`, `boolean`, `String` ;
- écrire des conditions `if / else if / else` ;
- écrire des boucles `for` et `while` ;
- écrire une méthode `static` avec paramètres et valeur de retour ;
- appeler tes méthodes depuis `main`.

Si tout est clair, tu peux passer au **Jour 3** (classes et objets : `Task`, constructeur, getters/setters).
