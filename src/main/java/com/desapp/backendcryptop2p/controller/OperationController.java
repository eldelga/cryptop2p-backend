package com.desapp.backendcryptop2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.desapp.backendcryptop2p.model.OperationReadDTO;
import com.desapp.backendcryptop2p.service.OperationService;



@RestController
public class OperationController {

    @Autowired
    private OperationService operationService ;

    @GetMapping(value = "/operation/sendAmount/{operationId}")
    public OperationReadDTO sendAmount(@PathVariable Integer operationId,Authentication authentication) {
        if (!authentication.isAuthenticated()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "please log in");
        }
            
        return operationService.sendAmount(operationId);
    }

    @GetMapping(value = "/operation/sendCryptos/{operationId}")
    
    public OperationReadDTO sendCryptos(@PathVariable Integer operationId,Authentication authentication) {
        if (!authentication.isAuthenticated()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "please log in");
        }
        return operationService.sendCryptos(operationId);
    }
}
