## Jour 7 – Finalisation et packaging

Objectif du jour : produire une version backend finale, stable et exécutable.

---

## 1. Checklist finale

- CRUD `tasks` fonctionnel,
- persistance JPA + migrations Flyway,
- validation + erreurs uniformes,
- sécurité JWT active,
- tests essentiels passants.

---

## 2. Vérification de qualité

Avant packaging :

1. lancer les tests,
2. tester login + endpoints protégés,
3. vérifier profils/config env,
4. vérifier format des erreurs.

---

## 3. Packaging

```bash
mvn clean package
java -jar target/tasks-api-*.jar
```

Option :

- ajouter un `README` d’exécution avec variables env nécessaires.

---

## 4. Définition de fin de formation

Tu as terminé le parcours si tu peux :

- démarrer ton API sur une machine propre,
- te connecter, obtenir un token JWT, appeler tes endpoints,
- manipuler des données persistées en base,
- faire évoluer le code sans casser les tests principaux.

Félicitations : tu as une base solide pour faire du backend Java en conditions réelles.

