package com.desapp.backendcryptop2p.e2e;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.model.UserFactory;


@SpringBootTest
public class UserTests {

    private User anyUser ;
    


    @BeforeEach
    void setUp() {
       anyUser = UserFactory.anyUser();
    }

}