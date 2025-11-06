package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.UserRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

// Service-laget indeholder forretningslogik mellem Controller og Repository
@Service
public class UserService {

    private UserRepository userRepository;

    // Constructor med dependency injection af repository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Forsøger at oprette en ny bruger
    public boolean createUser(String userName, String email, String userPassword) {
        try {
            // Kalder repository for at indsætte brugeren i databasen
            userRepository.createUser(userName, email, userPassword);
            System.out.println("Bruger oprettet: " + userName + " " + email);
            return true; // Returnerer true hvis det lykkedes
        }
        // Hvis email allerede findes i databasen
        catch (DuplicateKeyException e) {
            System.out.println("Email allerede i brug: " + email);
            e.printStackTrace();
            return false;
        }
        // Andre uventede fejl
        catch (Exception e) {
            System.out.println("Uventet fejl ved oprettelse af bruger: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Validerer login ved at tjekke database for match
    public int validateLogin(String username, String userPassword) {
        int id = 0;
        id = userRepository.validateLogin(username, userPassword);
        return id;
    }
}
