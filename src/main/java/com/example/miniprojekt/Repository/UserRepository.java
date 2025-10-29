package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(String userName, String email, String userPassword) {
        jdbcTemplate.update("INSERT INTO user(userName, email, userPassword) VALUES (?, ? , ?) ",
                userName, email, userPassword);
        System.out.println(userName + email + userPassword);
    }
}
