import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.8.20"

	application
	kotlin("jvm") version "${kotlinVersion}"
	kotlin("plugin.spring") version "${kotlinVersion}"
	
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"

	id("org.flywaydb.flyway") version "9.17.0"
}

group = "io.reflectoring"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.projectlombok:lombok")

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Spring
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Database
    implementation("org.flywaydb:flyway-core")
	//testRuntimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	// Add jaxb since it's no longer available in Java 11
	runtimeOnly("javax.xml.bind:jaxb-api:2.3.1")

    // Test
	testImplementation("org.assertj:assertj-core")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
	testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

// See https://flywaydb.org/documentation/usage/gradle/baseline
flyway {
	//url = "jdbc:h2:mem:"
	url = "jdbc:postgresql://127.0.0.1:5432/"
	locations = arrayOf(
		"db/specific/postgres",
		// Add this if you have jvm-based migrations
		"classpath:db/migration"
	)
	cleanDisabled = false
}

kotlin {
	jvmToolchain(17)
}
