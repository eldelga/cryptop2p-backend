package com.desapp.backendcryptop2p.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.desapp.backendcryptop2p.service.OfferService;
import com.desapp.backendcryptop2p.model.OfferCreateDTO;
import com.desapp.backendcryptop2p.model.OfferReadDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class OfferController {
    
    @Autowired
    private OfferService offerService;

    @GetMapping(value = "/offers")
    public List<OfferReadDTO> getAll() {
        return offerService.getAll();
    }             

    @PostMapping(value = "/offers")
    public OfferCreateDTO save(@RequestBody OfferCreateDTO offerDTO) {
       return this.offerService.create(offerDTO);
    }
}