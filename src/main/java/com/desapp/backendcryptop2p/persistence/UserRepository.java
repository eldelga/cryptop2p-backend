package com.desapp.backendcryptop2p.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import com.desapp.backendcryptop2p.model.User;


public interface UserRepository extends JpaRepository<User,Integer> {}
