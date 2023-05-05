# Database migrations

# Alternatives:

* [flyway](https://documentation.red-gate.com/fd/welcome-to-flyway-184127914.html): -- de facto standard --  uses plain SQL or a JVM language (Java)
* [Liquibase](https://docs.liquibase.com/concepts/introduction-to-liquibase.html): uses a DSL to define migrations

## Flyway

**!!! There are a lot of SQL dialects: if you use a different DB in prod vs dev you may encounter some issues**

[Testcontainers](https://www.testcontainers.org/) may be very helpful to ensure dev/prod parity

* [gradle commands](https://flywaydb.org/documentation/usage/gradle/)
* [gradle example](https://documentation.red-gate.com/fd/quickstart-gradle-184127577.html)

## Commands

```bash
./gradlew flywayValidate --info
./gradlew flywayMigrate --info
./gradlew flywayInfo --info
./gradlew flywayClean --info
./gradlew flywayRepair --info

```

registers all migrations in `flyway_schema_history` table

**!!! Undo reserved to "enterprise" editions** :-(

## Resources

* [DB migration with flyway](https://reflectoring.io/database-migration-spring-boot-flyway/)
* [Baeldung](https://www.baeldung.com/database-migrations-with-flyway)
* [Tool-based Database Refactoring: Flyway vs. Liquibase](https://reflectoring.io/database-refactoring-flyway-vs-liquibase/)

