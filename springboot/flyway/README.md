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

## Homework

### Bookstore
1. Create a book repository whose backing table is created by flyway.
   A book has an isbn (unique), a title, a year of edition, and a price
2. Populate the book repository
3. Add a Book controller with read and search methods
4. Create the author repository. An author has first, last names, a birthdate and an optional deceased date
5. Populate the book repository with authors
6. Create relationship between book and authors. Modify the bookentity in accordance.
7. Populate the relationship

