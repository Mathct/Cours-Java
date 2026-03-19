## Jour 6 – Tests d’intégration API

Objectif : tester les endpoints HTTP.

## Options

- `@WebMvcTest` + Mock service
- `@SpringBootTest` + `@AutoConfigureMockMvc`

## Cas à couvrir

- `GET /tasks` -> 200
- `GET /tasks/{id}` absent -> 404
- `POST /tasks` valide -> 201
- `POST /tasks` invalide -> 400
- `DELETE /tasks/{id}` -> 204

## Validation

- Les routes critiques sont couvertes par tests d’intégration.

