package com.example.miniprojekt.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Repository-klassen kommunikerer direkte med databasen
@Repository
public class UserRepository {

    // JdbcTemplate bruges til at køre SQL-queries
    private final JdbcTemplate jdbcTemplate;

    // Constructor - Spring injicerer JdbcTemplate automatisk
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Indsætter en ny bruger i databasen
    public void createUser(String userName, String email, String userPassword) {
        jdbcTemplate.update("INSERT INTO user(username, email, user_password) VALUES (?, ?, ?)",
                userName, email, userPassword);
        System.out.println(userName + email + userPassword);
    }

    // Tjekker om brugernavn og kode passer til en eksisterende bruger
    public int validateLogin(String username, String userPassword) {
        int id = 0;
        id = jdbcTemplate.queryForObject(
                "SELECT user_id FROM user WHERE username = ? AND user_password = ?",
                Integer.class, username, userPassword); //Integer.class fortæller, at vi forventer at få et heltal tilbage (user_id).

        return id; // Returnerer brugerens ID, hvis fundet
    }
}
