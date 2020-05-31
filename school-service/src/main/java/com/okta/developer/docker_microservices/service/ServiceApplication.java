package com.okta.developer.docker_microservices.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot project that acts as the project's persistence layer and business
 * rules, it was created using Spring Initializr
 * 
 *  Group — com.okta.developer.docker_microservices
 *  Artifact — school-service
 *  Dependencies — JPA, Web, Lombok, H2
 *  
 *  ./mvnw spring-boot:run makes it run on port defined at src/resources/application.properties (8081)
 *  
 *  More informations at: https://developer.okta.com/blog/2019/02/20/spring-boot-with-postgresql-flyway-jsonb
 */
@SpringBootApplication
public class ServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
