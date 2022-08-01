package com.yectra.Springbootkeycloak.service;

import javax.ws.rs.core.Response;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yectra.Springbootkeycloak.model.CreateUser;


@Service
public class KeycloakAdminClientService
{
	
    @Value("${keycloak.realm}")
    public String realm;

    @Autowired
     Keycloak keycloak;


    public KeycloakAdminClientService(Keycloak keycloak1) {
        this.keycloak = keycloak1;
    }

    public Response createKeycloakUser(CreateUser user) {
        UsersResource usersResource = keycloak.realm(realm).users();
       // CredentialRepresentation credentialRepresentation = createPasswordCredentials(user.getPassword());

        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(user.getEmail());
     //   kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setFirstName(user.getFirstname());
        kcUser.setLastName(user.getLastname());
        kcUser.setEmail(user.getEmail());
        kcUser.setEnabled(true);
        kcUser.setEmailVerified(false);

        Response response = usersResource.create(kcUser);
		return response;

    }


}