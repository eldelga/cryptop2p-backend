package com.desapp.backendcryptop2p.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.desapp.backendcryptop2p.dto.CryptoActiveDTO;

import com.desapp.backendcryptop2p.service.CryptoActiveService;

@RestController
public class CryptoActiveController {
    
    @Autowired
    private CryptoActiveService cryptoActiveService;

    @GetMapping(value = "/cryptos")
    public Iterable<CryptoActiveDTO> getAll() {
        return cryptoActiveService.findMaxdates();
    }

    @GetMapping(value = "/cryptos/getLast/hours/{hours}")
    public Iterable<CryptoActiveDTO> getAllBefore(@PathVariable Integer hours) {
        return cryptoActiveService.getAllBefore(hours);
    }


   }
