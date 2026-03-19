## Jour 4 – Protéger `/tasks` avec JWT

Objectif du jour : appliquer l’auth JWT sur les endpoints métiers.

---

## 1. Protéger les routes

Configurer :

- `/auth/**` : public
- `/tasks/**` : authentifié obligatoire

---

## 2. Utiliser l’utilisateur courant

Dans les contrôleurs/services, récupérer l’utilisateur connecté via le `SecurityContext`.

Objectif :

- créer une tâche pour l’utilisateur courant,
- lister uniquement ses tâches.

---

## 3. Contrôle d’accès métier

Quand un user demande `GET /tasks/{id}` :

- vérifier que la tâche lui appartient,
- sinon renvoyer 403.

---

## 4. Exercices du jour

1. Forcer auth sur `/tasks/**`.
2. Associer `owner` lors de la création de tâche.
3. Filtrer les lectures/suppressions par owner.
4. Tester :
   - sans token -> 401
   - token autre user -> 403
   - bon token -> 200.

---

## 5. Validation du jour

Tu as fini si :

- la sécurité n’est pas seulement “technique”, elle protège aussi les données métier.

