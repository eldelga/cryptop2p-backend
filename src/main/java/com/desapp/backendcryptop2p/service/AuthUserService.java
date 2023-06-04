package com.desapp.backendcryptop2p.service;

import com.desapp.backendcryptop2p.dto.AuthUserDTO;
import com.desapp.backendcryptop2p.dto.TokenDTO;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.persistence.UserRepository;
import com.desapp.backendcryptop2p.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public User save(AuthUserDTO dto) {
        // User user = userRepository.getByEmail(dto.getEmail());
        String password = passwordEncoder.encode(dto.getPassword());
        User authUser = User.builder()
                .email(dto.getEmail())
                .password(password)
                .build();
        return userRepository.save(authUser);
    }

    public TokenDTO login(AuthUserDTO dto) {
        User user = userRepository.getByEmail(dto.getEmail());
        if(user == null)
            return null;
        if(passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            return new TokenDTO(jwtProvider.createToken(user));
        }
        return null;
    }

    public TokenDTO validate(String token) {
        if(!jwtProvider.validate(token))
            return null;
        String email = jwtProvider.getEmailFromToken(token);
        if(!(userRepository.getByEmail(email) == null))
            return null;
        return new TokenDTO(token);
    }
}
