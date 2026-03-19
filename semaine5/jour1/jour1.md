## Jour 1 – Spring Security : bases

Objectif du jour : activer Spring Security et comprendre comment protéger les routes.

---

## 1. Ajouter la dépendance

Dans `pom.xml` :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

---

## 2. Configurer `SecurityFilterChain`

Créer une classe de config :

```java
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**").permitAll()
            .requestMatchers("/actuator/health").permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
}
```

---

## 3. Tester le comportement

- Appel d’un endpoint protégé sans token -> 401.
- Appel d’un endpoint public (`/auth/**`) -> autorisé.

---

## 4. Exercices du jour

1. Ajouter dépendance sécurité.
2. Créer la config de sécurité.
3. Marquer `/auth/**` public et `/tasks/**` protégé.
4. Vérifier 401 sans authentification.

---

## 5. Validation du jour

Tu as fini si :

- ton API applique déjà une barrière d’accès,
- seules les routes explicitement publiques restent accessibles sans auth.

