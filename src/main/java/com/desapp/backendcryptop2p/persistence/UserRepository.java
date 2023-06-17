package com.desapp.backendcryptop2p.persistence;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desapp.backendcryptop2p.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("from User user where user.email = ?1")
    Optional<User> getByEmail(String email) ;
}
