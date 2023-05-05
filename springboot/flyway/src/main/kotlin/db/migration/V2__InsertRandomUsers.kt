package db.migration

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SingleConnectionDataSource

/**
 * Example of a kotlin-based migration using Spring {@link JdbcTemplate}.
 */
class V2__InsertRandomUsers: BaseJavaMigration() {

    override fun migrate(context: Context) {
        val jdbcTemplate = JdbcTemplate(SingleConnectionDataSource(context.connection, true))

        // Create 10 random users
        (1..10).forEach {
            jdbcTemplate.execute(
                String.format(
                    "insert into users(username, first_name, last_name) "
                            + "values('%d@reflectoring.io', 'Elvis_%d', 'Presley_%d')", it, it, it
                )
            )
        }
    }
}