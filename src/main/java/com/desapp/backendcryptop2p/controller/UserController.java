package com.desapp.backendcryptop2p.controller;
import java.util.List;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("user/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }
}
