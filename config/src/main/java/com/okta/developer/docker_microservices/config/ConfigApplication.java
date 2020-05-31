package com.okta.developer.docker_microservices.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Configuration Server to Microservices Architecture
 * 
 * First, configuration URL was removed from the project and became managed by Eureka server.
 * Now we can do a similar thing for every configuration on the project using Spring Cloud Config.
 *
 * Group: com.okta.developer.docker_microservices
 * Artifact: config
 * Dependencies: Config Server, Eureka Discovery
 * 
 * Don't forget: @EnableConfigServer
 * 
 * Check applications.properties containing some configuration.
 * 
 * Run ./mvnw spring-boot:run
 * - Added OKTA credentials
 * curl http://localhost:8888/school-ui.properties
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
