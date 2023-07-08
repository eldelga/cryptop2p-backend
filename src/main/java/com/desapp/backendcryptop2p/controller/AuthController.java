package com.desapp.backendcryptop2p.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.model.UserCreateDTO;
import com.desapp.backendcryptop2p.security.AuthRequestDTO;
import com.desapp.backendcryptop2p.security.AuthResponse;
import com.desapp.backendcryptop2p.security.JwtTokenUtil;
import com.desapp.backendcryptop2p.service.UserService;


 
@RestController
public class AuthController {
    @Autowired AuthenticationManager authManager;
    @Autowired JwtTokenUtil jwtUtil;
    @Autowired private UserService userService;
     
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequestDTO request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
             
            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
             
            return ResponseEntity.ok().body(response);
             
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/auth/createUser")
    public UserCreateDTO createUser(@RequestBody @Valid UserCreateDTO request) {
        return userService.create(request);
    }
}