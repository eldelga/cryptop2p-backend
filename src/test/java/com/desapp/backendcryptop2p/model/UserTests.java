package com.desapp.backendcryptop2p.model;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;





@SpringBootTest
public class UserTests {

    private User anyUser ;
    


    @BeforeEach
    void setUp() {

        anyUser = UserFactory.anyUser();
    }

    @Test
    public void isTrueTest(){
        assertTrue(true, "ok");
    }

    @Test
    void shouldFailValidationWhenUsernameIsEmpty() {

   
    }
}