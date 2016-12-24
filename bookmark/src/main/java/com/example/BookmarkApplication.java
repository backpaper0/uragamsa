package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@SpringBootApplication
@EnableOAuth2Sso
public class BookmarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmarkApplication.class, args);
    }

    @Bean
    OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails resource) {
        return new OAuth2RestTemplate(resource);
    }
}
