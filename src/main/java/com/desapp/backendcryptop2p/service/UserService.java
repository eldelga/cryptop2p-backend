package com.desapp.backendcryptop2p.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desapp.backendcryptop2p.model.User;
import java.util.List;
import com.desapp.backendcryptop2p.persistence.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

}
