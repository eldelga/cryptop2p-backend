package com.desapp.backendcryptop2p.controller;

import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users", notes = "Returns all users")
    @ApiResponses(value={
        @ApiResponse(code=200, message = "OK"),
        @ApiResponse(code=400,message = "Bad Request")
    })
    @GetMapping(value = "/users")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @ApiOperation(value = "Create new user", notes = "")
    @ApiResponses(value={
        @ApiResponse(code=200, message = "OK"),
        @ApiResponse(code=400,message = "Bad Request")
    })
    @PostMapping(value = "/user")
    public void save(@RequestBody User user) {
       this.userService.create(user);
    }

    @PutMapping(value = "/user")
    public void update(@RequestBody User user) {
        this.userService.create(user);
    }

    @DeleteMapping(value = "/user")
    public void delete(@RequestParam Integer id) {
        this.userService.delete(id);
    }
}
