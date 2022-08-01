package com.yectra.Springbootkeycloak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yectra.Springbootkeycloak.model.CreateUser;
import com.yectra.Springbootkeycloak.model.LoginRequestDTO;
import com.yectra.Springbootkeycloak.model.UserToken;
import com.yectra.Springbootkeycloak.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createUser(@RequestBody CreateUser user) {
		return userService.createUser(user);
	}

	@PostMapping(value = "/gettoken")
	public UserToken userToken(@RequestBody LoginRequestDTO loginRequestDTO) {
		return userService.userToken(loginRequestDTO);

	}

}
