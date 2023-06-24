package com.desapp.backendcryptop2p.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;

@RestController
public class HelloController {


	@ApiImplicitParam(name = "Authorization", value = "Access token", required = true, paramType = "header")
	@GetMapping("/checkAuthUserEmail")
	public String checkAuthUserEmail(Authentication authCredential) {
  		UserDetails userPrincipal = (UserDetails)authCredential.getPrincipal(); 
		return userPrincipal.getUsername();
	}



}