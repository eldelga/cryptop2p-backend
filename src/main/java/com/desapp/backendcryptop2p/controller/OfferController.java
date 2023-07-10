package com.desapp.backendcryptop2p.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desapp.backendcryptop2p.service.OfferService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import com.desapp.backendcryptop2p.dto.OfferCreateDTO;
import com.desapp.backendcryptop2p.dto.OfferReadDTO;
import com.desapp.backendcryptop2p.dto.OperationReadDTO;
import com.desapp.backendcryptop2p.model.ModelException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)


@RestController
public class OfferController {
    
    @Autowired
    private OfferService offerService;

    
    @GetMapping(value = "/offers")
    public List<OfferReadDTO> getAll() {
        return offerService.getAll();
    }
    
    @GetMapping(value = "/offer/cancel/{id}")
    public OfferReadDTO cancel(@PathVariable Integer id,Authentication authentication) {
        try{
            return offerService.cancel(id,authentication.getName());
        }catch(ModelException ex){
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
        
    }       

    @GetMapping(value = "/offer/take/{id}")
    public OperationReadDTO take(@PathVariable Integer id,Authentication authentication) {
        try{
            return offerService.take(id,authentication.getName());
        }catch(ModelException ex){
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
    } 

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping(value = "/offers") 
    public OfferCreateDTO save(@RequestBody OfferCreateDTO offerDTO,Authentication authentication) {
        try{
            return this.offerService.create(offerDTO,authentication.getName());
        }catch(ModelException ex){
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
    }
}