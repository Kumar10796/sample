package com.yectra.Springbootkeycloak.configuration;

import org.springframework.beans.factory.annotation.Value;


public class KeycloakProvider{


    @Value("${keycloak.auth-server-url}")
    public String serverURL;
    @Value("${keycloak.realm}")
    public String realm;
    @Value("${keycloak.resource}")
    public String clientID;
    @Value("${keycloak.credentials.secret}")
    public String clientSecret;
	

//
//    public KeycloakBuilder newKeycloakBuilderWithPasswordCredentials(String username, String password) {
//        return KeycloakBuilder.builder() //
//                .realm(realm) //
//                .serverUrl(serverURL)//
//                .clientId(clientID) //
//                .clientSecret(clientSecret) //
//                .username(username) //
//                .password(password);

/*
	public JsonNode refreshToken(String refreshToken) throws UnirestException {
        String url = serverURL + "/realms/" + realm + "/protocol/openid-connect/token";
        return Unirest.post(url)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("client_id", clientID)
                .field("client_secret", clientSecret)
                .field("refresh_token", refreshToken)
                .field("grant_type", "refresh_token")
                .asJson().getBody();
    }*/
}
