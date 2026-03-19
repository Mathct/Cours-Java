## Jour 6 – Tests d’intégration API

Objectif du jour : valider le comportement réel HTTP de ton API.

---

## 1. Choisir la stratégie

- `@WebMvcTest` : rapide, ciblé contrôleurs (service mocké).
- `@SpringBootTest + @AutoConfigureMockMvc` : plus réaliste (contexte complet).

Pour ton parcours, commence par `@WebMvcTest`, puis ajoute 1-2 tests `@SpringBootTest`.

---

## 2. Cas critiques à tester

- `GET /tasks` -> 200 + JSON attendu,
- `GET /tasks/{id}` absent -> 404,
- `POST /tasks` valide -> 201,
- `POST /tasks` invalide -> 400,
- `DELETE /tasks/{id}` -> 204.

---

## 3. Exemple MockMvc

```java
mockMvc.perform(post("/tasks")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\":\"Task A\",\"ownerId\":1}"))
    .andExpect(status().isCreated())
    .andExpect(jsonPath("$.title").value("Task A"));
```

---

## 4. Exercices du jour

1. Créer une classe de tests d’intégration contrôleur.
2. Coder 5 scénarios (200/201/204/400/404).
3. Vérifier le format d’erreur JSON standardisé.

---

## 5. Validation du jour

Tu as fini si :

- les routes principales sont testées automatiquement,
- tu détectes vite les régressions d’API.

