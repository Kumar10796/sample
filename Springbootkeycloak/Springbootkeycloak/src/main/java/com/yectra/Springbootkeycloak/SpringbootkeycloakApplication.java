package com.yectra.Springbootkeycloak;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootkeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootkeycloakApplication.class, args);
	}
	
	@Bean 
	 public static Keycloak getInstance() {
            return KeycloakBuilder.builder()
                    .realm("demo")
                    .serverUrl("http://localhost:8080/auth")
                    .clientId("demo-client")
                    .clientSecret("4BXLBWWIWvMSQM98tjnJ2EscdJYYrj5Z")
                    .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                    .build();
        
      }
	  @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
	
}
