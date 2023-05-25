package com.desapp.backendcryptop2p.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;



@RestController
public class HelloController {

	@GetMapping("/hello")
	public RedirectView index() {
		return new RedirectView("/swagger-ui/index.html");
	}

}
