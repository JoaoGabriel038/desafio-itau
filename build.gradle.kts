plugins {
	java
	id("org.springframework.boot") version "3.5.12"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.joaogabrieldev"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.3")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-api:2.8.3")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	constraints {
		implementation("org.apache.commons:commons-lang3:3.18.0") {
			because("A versão 3.17.0 possui vulnerabilidade de segurança reportada pelo Mend.io")
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
