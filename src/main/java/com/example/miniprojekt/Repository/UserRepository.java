package com.example.miniprojekt.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(String userName, String email, String userPassword) {
        jdbcTemplate.update("INSERT INTO user(username, email, user_password) VALUES (?, ? , ?) ",
                userName, email, userPassword);
        System.out.println(userName + email + userPassword);
    }

    public int validateLogin(String username, String userPassword) {
        int id = 0;
        id = jdbcTemplate.queryForObject("SELECT user_id FROM user WHERE username = ? AND user_password = ?",
        Integer.class, username, userPassword);

        return id;
    }
}