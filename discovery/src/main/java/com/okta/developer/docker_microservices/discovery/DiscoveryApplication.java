package com.okta.developer.docker_microservices.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * In modern applications, developers or operations usually don't know where or
 * what port an application might be deployed on. The deployment should be
 * automated so that no one cares about server names and physical location.
 *
 * Nonetheless, it's essential to have a tool that helps the services to
 * discover their counterparts. There are many solutions available, here we're
 * going to use Eureka from Netflix as it has outstanding Spring support.
 * 
 * Group: com.okta.developer.docker_microservices
 * Artifact: discovery
 * Dependencies: Eureka Server
 * 
 * ./mvnw spring-boot:run
 * 
 * Available at http://localhost:8761
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }

}
