package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Repository.UserRepository;
import com.example.miniprojekt.Repository.WishItemRepository;
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


    public UserModel logInUser(String email, String password) {
        System.out.println("Forsøger login: " + email);
        UserModel user = userRepository.logInUser(email, password);  // RETTET: modtag UserModel

        if (user != null) {
            System.out.println("✓ Login succesfuld: " + user.getUserName());
        } else {
            System.out.println("✗ Login fejlet");
        }

        return user;  // RETTET: returner user
    }
}
