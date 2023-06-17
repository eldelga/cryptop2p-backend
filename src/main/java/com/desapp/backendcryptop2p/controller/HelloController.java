package com.desapp.backendcryptop2p.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;

@RestController
public class HelloController {

	@ApiImplicitParam(name = "Authorization", value = "Access token", required = true, paramType = "header")
	@GetMapping("/hello")
	public String index(HttpServletRequest request) {
		String token = (String) request.getAttribute("token");

        // Aquí puedes usar el token como lo necesites en tu controlador

        return "Token: " + token;

	}

}
