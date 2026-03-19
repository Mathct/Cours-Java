## Jour 5 – Tests unitaires (JUnit + Mockito)

Objectif du jour : tester rapidement la logique métier sans démarrer toute l’application Spring.

---

## 1. Setup de base

`spring-boot-starter-test` suffit dans la majorité des cas.

Classe de test type :

```java
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock TaskRepository taskRepository;
    @InjectMocks TaskService taskService;
}
```

---

## 2. Cas à couvrir en priorité

- création de tâche,
- récupération par id (cas trouvé + introuvable),
- marquage “done” (cas normal + déjà done).

---

## 3. Pattern recommandé

- Given (préparation mocks/données),
- When (appel méthode service),
- Then (assertions + `verify` interactions).

Exemple :

```java
when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
TaskResponse out = taskService.getById(1L);
assertEquals(1L, out.getId());
verify(taskRepository).findById(1L);
```

---

## 4. Exercices du jour

1. Créer `TaskServiceTest`.
2. Écrire 3 à 5 tests unitaires clés.
3. Ajouter au moins 1 test d’exception métier.

---

## 5. Validation du jour

Tu as fini si :

- les règles métier critiques sont couvertes par tests unitaires,
- tous les tests passent en vert.

