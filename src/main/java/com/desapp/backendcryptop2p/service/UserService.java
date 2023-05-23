package com.desapp.backendcryptop2p.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desapp.backendcryptop2p.component.MapperComponent;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.model.UserCreateDTO;
import com.desapp.backendcryptop2p.model.UserReadDTO;
import com.desapp.backendcryptop2p.persistence.UserRepository;
import java.util.List;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperComponent modelMapper;
    
    public List<UserReadDTO> getAll() {
        return this.modelMapper.ToList(this.userRepository.findAll(), UserReadDTO.class);
    }

    public User getByEmail(String email){
        return this.userRepository.getByEmail(email);
    }

    public UserCreateDTO create(UserCreateDTO user) {
        User newUser = this.modelMapper.To(user, User.class) ; 
        newUser.setSucessfulOperations(0);
        newUser.setTotalOperations(0);
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
