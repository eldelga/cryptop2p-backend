package com.desapp.backendcryptop2p.controller;


import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.desapp.backendcryptop2p.model.Quotation;



@RestController
public class HelloController {

	@GetMapping("/hello")
	public RedirectView index() {
            String uri = String.format("https://www.dolarsi.com/api/api.php?type=valoresprincipales");
            RestTemplate restTemplate = new RestTemplate();
			Quotation[] q = restTemplate.getForObject(uri, Quotation[].class);
			for (Quotation actual : q) {
				System.out.println(actual.getNombre());
			}
			// this.cryptoActiveRepository.save(cryptoActive);
        

		return new RedirectView("/swagger-ui/index.html");
	}

}
