package io.reflectoring.flyway;

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FlywayMigrationTest {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun databaseHasBeenInitialized() {

        //jdbcTemplate.execute("insert into users (username, first_name, last_name) values('reflectoring', 'Elvis', 'Presley')");

        val authUsers = jdbcTemplate.query("SELECT username, first_name, last_name FROM users") { rs, _ ->
            AuthUser(
                rs.getString("username"),
                rs.getString("first_name"),
                rs.getString("last_name")
            )
        }
        assertThat(authUsers).isNotEmpty();
    }

    data class AuthUser(public val username: String, public val firstName: String, public val lastName: String) {}
}