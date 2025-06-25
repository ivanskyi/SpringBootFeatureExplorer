# Testcontainers

## What is it?
A library to run Docker containers during Java tests.

## Why use it?
To test with a real database, isolated and automated without manual environment setup.

## How to run?

1. Add Testcontainers dependency to `pom.xml` or `build.gradle`.

2. In your test, start a container, for example PostgreSQL:

```java
@Container
static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15");

@DynamicPropertySource
static void configure(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
}
```

3. Run tests — container starts automatically.

## Who creates tables?
Usually Hibernate (via `spring.jpa.hibernate.ddl-auto=update/create`) — automatically at test startup.

---

1. **What is Testcontainers?**  
   A library to run Docker containers during Java tests.

2. **How to integrate Testcontainers with Spring Boot?**  
   Add dependency, start container in tests, pass config via `@DynamicPropertySource`.

3. **How does Testcontainers integrate with JUnit 5?**  
   Using `@Testcontainers` and `@Container` annotations.

4. **Is Docker installation required for Testcontainers?**  
   Yes, Docker must be installed and running.

5. **How does Testcontainers provide DB config to Spring Boot?**  
   Using `DynamicPropertyRegistry` in method annotated with `@DynamicPropertySource`.

6. **How to ensure single container instance for all tests?**  
   Declare container static in test class with `@Container`.

7. **Can multiple containers run simultaneously?**  
   Yes, Testcontainers supports multi-container setups.

8. **How to clean data after tests?**  
   Container is restarted or data is manually cleared during tests.

9. **Does Testcontainers support other services besides databases?**  
   Yes, Kafka, Redis, Elasticsearch, and many more.

10. **How does automatic table creation work in Testcontainers tests?**  
    Spring/Hibernate creates tables if `spring.jpa.hibernate.ddl-auto` is enabled.
