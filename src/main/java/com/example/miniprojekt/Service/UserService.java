package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(String userName, String email, String userPassword) {
        try {
            userRepository.createUser(userName, email, userPassword);
            System.out.println("Bruger oprettet: " + userName + " " + email);
            return true;
        } catch (DuplicateKeyException e) {
            System.out.println("Email allerede i brug: " + email);
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("Uventet fejl ved oprettelse af bruger: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
