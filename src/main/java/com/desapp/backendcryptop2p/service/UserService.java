package com.desapp.backendcryptop2p.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desapp.backendcryptop2p.component.MapperComponent;
import com.desapp.backendcryptop2p.dto.AuthUserDTO;
import com.desapp.backendcryptop2p.dto.UserCreateDTO;
import com.desapp.backendcryptop2p.dto.UserReadDTO;
import com.desapp.backendcryptop2p.model.ModelException;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.persistence.UserRepository;
import java.util.List;



@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperComponent modelMapper;
    
    public List<UserReadDTO> getAll() {
        return this.modelMapper.toList(this.userRepository.findAll(), UserReadDTO.class);
    }


    public User getByEmail(String email) throws ModelException{
        return this.userRepository.getByEmail(email).orElseThrow(() -> new ModelException("No user found"));
        
    }

    public UserCreateDTO create(UserCreateDTO user) {
        User newUser = this.modelMapper.to(user, User.class) ; 
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        newUser.setSucessfulOperations(0);
        newUser.setTotalOperations(0);
        newUser.setPassword(password);
        newUser.updateRate();
        this.userRepository.save(newUser);
        return user;
    }

    public User update(User user) {
        return this.userRepository.save(user) ;
    }

    public User getById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }

}
