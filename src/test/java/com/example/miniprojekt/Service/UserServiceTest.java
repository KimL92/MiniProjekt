package com.example.miniprojekt.Service;


import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser(){
        String userName = "aden91";
        String email = "gg2020@simo.ek.dk";
        String userPassword = "mo123";

        // noter: her udfører vi metoden
        userService.createUser(userName,email,userPassword);

        // her tjekker vi om at repository blev kaldt korrekt
        verify(userRepository,times(1)).createUser(userName,email,userPassword);
    }
}
