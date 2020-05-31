package com.okta.developer.docker_microservices.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * UI that consumes school-service REST API. Created using Spring Initializr
 * with the following options:
 * 
 * Group — com.okta.developer.docker_microservices Artifact — school-ui
 * Dependencies — Web, Hateoas, Thymeleaf, Lombok
 * 
 * Single web page that lists the classes available on database. To connect to
 * school-service, it uses resources/application/properties (service.host)
 *
 * ./mvnw spring-boot:run and go to http://localhost:8080
 */
@SpringBootApplication
public class UIWebApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(UIWebApplication.class, args);
	}


	/**
     * The school-service may have multiple instances of and it would be a good idea
     * to load balance the calls between the instances. Thankfully, Spring has a
     * simple solution: on the RestTemplate bean creation, add @LoadBalanced
     * annotation as follows. Spring will manage multiple instance calls each time
     * you ask something to the server.
     * 
     * @return
     */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!registry.hasMappingForPattern("/static/**")) {
			registry
					.addResourceHandler("/static/**")
					.addResourceLocations("classpath:/static/", "classpath:/static/js/");
		}
	}
}
