package com.desapp.backendcryptop2p.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.persistence.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Iterable<User> getAll() {
        return this.userRepository.findAll();
    }

    public User create(User user) {
        return this.userRepository.save(user) ;
    }


}
