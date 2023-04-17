package com.desapp.backendcryptop2p.persistence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desapp.backendcryptop2p.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {}
