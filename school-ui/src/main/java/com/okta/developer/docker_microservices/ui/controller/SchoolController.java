package com.okta.developer.docker_microservices.ui.controller;

import com.okta.developer.docker_microservices.ui.dto.TeachingClassDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class SchoolController {

    private final RestTemplate restTemplate;
    // Not needed anymore after setting up Eureka
    // private final String serviceHost;

    public SchoolController(RestTemplate restTemplate /**, @Value("${service.host}") String serviceHost **/) {
        this.restTemplate = restTemplate;
        // this.serviceHost = serviceHost;
    }

    /**
     * Returns index case access /
     * 
     * @return
     */
    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * Proxies the request to school-service
     * 
     * @return
     */
    @GetMapping("/classes")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public ResponseEntity<List<TeachingClassDto>> listClasses(){
        return restTemplate
                .exchange("http://school-service/class", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<TeachingClassDto>>() {});
    }
}
