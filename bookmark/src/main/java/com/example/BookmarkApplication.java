package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class BookmarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmarkApplication.class, args);
    }

    //    @Bean
    //    OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails resource) {
    //        return new OAuth2RestTemplate(resource);
    //    }
}
