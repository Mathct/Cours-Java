## Jour 7 – Mini-projet semaine 3 (persisté)

Objectif du jour : assembler toutes les briques de persistance dans une version stable de ton API.

---

## 1. Fonctionnalités à avoir

- CRUD `Task` complet en base.
- `Task` liée à `User`.
- Requêtes filtrées (`done`, `keyword`).
- Pagination/tri.
- Migrations Flyway actives.

---

## 2. Scénario de test complet

1. Créer un user.
2. Créer 3 tâches liées à ce user.
3. Vérifier `GET /tasks?ownerId={id}`.
4. Filtrer `GET /tasks?done=false`.
5. Mettre à jour une tâche (`done=true`).
6. Supprimer une tâche.
7. Redémarrer l’application et vérifier que les données restantes sont toujours présentes.

---

## 3. Points de qualité à vérifier

- IDs en `Long`.
- Réponses 404 si ressource absente.
- Pas de logique SQL dans les contrôleurs.
- Pas de retour brut d’entité relationnelle si ça crée des boucles JSON.

---

## 4. Validation de fin de semaine 3

Tu as terminé la semaine 3 si :

- ton API lit/écrit uniquement via JPA et PostgreSQL,
- les migrations DB sont en place,
- tu es prêt à renforcer la qualité d’API (DTO/validation/tests) en semaine 4.

