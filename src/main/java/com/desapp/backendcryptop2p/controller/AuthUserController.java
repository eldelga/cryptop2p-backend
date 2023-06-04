package com.desapp.backendcryptop2p.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desapp.backendcryptop2p.dto.AuthUserDTO;
import com.desapp.backendcryptop2p.dto.TokenDTO;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.service.AuthUserService;


@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    AuthUserService authUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthUserDTO dto){
        TokenDTO tokenDto = authUserService.login(dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDTO> validate(@RequestParam String token){
        TokenDTO tokenDto = authUserService.validate(token);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody AuthUserDTO dto){
        User user = authUserService.save(dto);
        if(user == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(user);
    }
}
