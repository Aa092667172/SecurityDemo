package com.example.securitydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class UserEntityRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test(){
        assertEquals(userRepository.findAll().size(),2);
    }
}