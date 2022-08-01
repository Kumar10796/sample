package com.yectra.Springbootkeycloak.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.yectra.Springbootkeycloak.model.CreateUser;
import com.yectra.Springbootkeycloak.model.LoginRequestDTO;
import com.yectra.Springbootkeycloak.model.UserToken;
import com.yectra.Springbootkeycloak.repository.CreateUserRepository;

@Service
public class UserService {

	@Autowired
	private CreateUserRepository createuserRepository;

	@Autowired
	Keycloak keycloak;

	@Value("${keycloak.resource}")
	private String clientId;

	@Value("${keycloak.credentials.secret}")
	private String clientSecret;

	private static final String Login_User_URL = "http://localhost:8080/auth/realms/Thiru/protocol/openid-connect/token";

	public ResponseEntity<?> createUser(@RequestBody CreateUser user) {

		RealmResource realmResource = keycloak.realm("Thiru");

		List<UserRepresentation> users = realmResource.users().search(user.getUsername());
		if (!users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UserRepresentation userRepresentation = new UserRepresentation();
		userRepresentation.setEnabled(true);
		userRepresentation.setUsername(user.getUsername());
		userRepresentation.setEmail(user.getEmail());
		userRepresentation.setLastName(user.getLastname());
		userRepresentation.setFirstName(user.getFirstname());

		Response userResource = keycloak.realm("Thiru").users().create(userRepresentation);
		String userId = CreatedResponseUtil.getCreatedId(userResource);
		System.out.println("userId : " + userId);
		UserResource createdUser = getUser(userId);
		createdUser.resetPassword(createPasswordCredentials(user.getPassword()));

		return new ResponseEntity(HttpStatus.OK);
	}

	private static CredentialRepresentation createPasswordCredentials(String password) {
		CredentialRepresentation passwordCredentials = new CredentialRepresentation();
		passwordCredentials.setTemporary(false);
		passwordCredentials.setType(CredentialRepresentation.PASSWORD);
		passwordCredentials.setValue(password);
		return passwordCredentials;
	}

	private UserResource getUser(String userId) {
		return keycloak.realm("Thiru").users().get(userId);
	}

	public UserToken userToken(LoginRequestDTO loginRequestDTO) {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		headers.add("Authorization ", "Bearer " + getKeyCloackToken());

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("client_id", clientId);
		requestBody.add("client_secret", clientSecret);
		requestBody.add("grant_type", OAuth2Constants.PASSWORD);
		requestBody.add("username", loginRequestDTO.getUserName());
		requestBody.add("password", loginRequestDTO.getPassword());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestBody, headers);

		UserToken userToken = restTemplate.postForObject(
				"http://localhost:8080/auth/realms/Thiru/protocol/openid-connect/token", request, UserToken.class);
		return userToken;

	}

}
