package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser (String userName, String email, String userPassword){
    userRepository.createUser(userName,email,userPassword);
        System.out.println(userName + email + userPassword);

    }
}
