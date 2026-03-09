## Jour 1 – Installation & premier contact avec Java

Objectif du jour : avoir un environnement Java prêt (JDK + IDE) et comprendre comment exécuter un premier programme Java simple (`Hello World`), plus un petit exercice d’affichage personnalisé.

---

## 1. Préparer l’environnement

### 1.1. Installer le JDK

- Installer un JDK (Java Development Kit) récent (Java 17 ou une version LTS actuelle).
- Vérifier dans un terminal :

```bash
java -version
javac -version
```

Tu dois voir une version (par exemple `17.x`).

si ca ne fonnction pas:

Étape 1 – Repérer le dossier du JDK

Ouvre l’Explorateur.
Va dans C:\Program Files\Java\ (ou parfois C:\Program Files\Eclipse Adoptium\ ou C:\Program Files\Oracle.
Tu devrais voir un dossier du style :
jdk-25.0.2
Ouvre-le, puis ouvre le sous-dossier bin.
Tu dois voir des fichiers comme java.exe, javac.exe, etc.
Copie le chemin complet, par exemple :
C:\Program Files\Java\jdk-25.0.2\bin

Étape 2 – Ajouter ce chemin au PATH

Clique droit sur Ce PC → Propriétés.
Clique sur Paramètres système avancés.
Bouton Variables d’environnement….
Dans Variables système, sélectionne Path → Modifier.
Clique sur Nouveau et colle le chemin copié (C:\Program Files\Java\jdk-25.0.2\bin).
Valide toutes les fenêtres avec OK.

(Optionnel mais conseillé)  
Toujours dans Variables système → Nouveau :

Nom de la variable : JAVA_HOME  
Valeur : C:\Program Files\Java\jdk-25.0.2 (sans \bin)

Étape 3 – Tester

Ferme complètement ton terminal PowerShell / CMD.
Rouvre un nouveau terminal.

```bash
java -version
javac -version
```

### 1.2. Choisir et installer l’IDE

Deux options principales :

- **IntelliJ IDEA Community** (recommandé pour Java)
- **VS Code** avec les extensions Java (si tu préfères rester dans VS Code)

L’important est d’avoir :

- la coloration syntaxique Java,
- la complétion,
- un bouton ou une commande pour lancer facilement le programme.

---

## 2. Créer un premier projet Java

Tu peux choisir :

- soit un **projet IntelliJ** de type “Java” ou “Maven/Gradle simple”,
- soit un **simple dossier** `semaine1/jour1` avec un fichier `Main.java` si tu préfères faire minimal au début.

Dans tous les cas, tu auras une structure similaire à :

- un dossier source (souvent `src` ou `src/main/java`),
- un fichier contenant une classe avec une méthode `main`.

Exemple de structure simple :

- `semaine1/`
  - `jour1/`
    - `src/`
      - `Main.java`

---

## 3. Comprendre la structure d’un programme Java minimal

Un programme Java **exécutable** a besoin d’une méthode `main` :

- La classe (par convention) commence par une majuscule (`Main`, `App`, etc.).
- La méthode `main` est **statique** et publique.

Structure minimale :

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

Points importants :

- `public class Main` : définition d’une classe nommée `Main`.
- `public static void main(String[] args)` : point d’entrée du programme.
- `System.out.println(...)` : affiche un texte dans la console.

---

## 4. Exécuter le programme

### 4.1. Avec l’IDE

- Ouvrir le projet dans ton IDE.
- Ouvrir la classe `Main`.
- Cliquer sur le bouton `Run` (ou équivalent).
- Vérifier que tu vois `Hello, world!` dans la console.

### 4.2. (Optionnel) En ligne de commande

Depuis le dossier contenant `Main.java` :

```bash
javac Main.java
java Main
```

- `javac` compile le fichier `.java` en `.class`.
- `java` exécute la classe compilée.

---

## 5. Petit exercice : programme de présentation

Objectif : manipuler l’affichage et modifier le message selon tes informations.

### 5.1. Consigne

Créer un programme Java qui affiche :

- ton **nom**,
- ton **langage de programmation préféré**,
- une phrase courte sur **ce que tu veux faire avec Java** (par exemple : “Je veux utiliser Java pour faire du backend avec Spring Boot”).

### 5.2. Exemple de structure

Tu peux t’inspirer de ce genre de code (à adapter avec tes infos) :

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Nom : [ton nom]");
        System.out.println("Langage préféré : [ton langage préféré]");
        System.out.println("Objectif avec Java : [ta phrase]");
    }
}
```

Modifie le contenu des `System.out.println` avec tes propres informations.

---

## 6. Validation de la journée

À la fin du Jour 1, tu dois être capable de :

- expliquer rapidement ce qu’est un JDK,
- ouvrir ton IDE et créer un projet Java simple,
- écrire une classe avec une méthode `main`,
- lancer le programme et voir le texte dans la console.

Si tout ça est bon, tu es prêt pour le **Jour 2** (variables, types, conditions, boucles et méthodes).