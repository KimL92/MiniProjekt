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
        jdbcTemplate.update("INSERT INTO usermodel(userName, email, userPassword) VALUES (?, ? , ?) ",
                userName, email, userPassword);
        System.out.println(userName + email + userPassword);
    }

//    // RETTET: Brug queryForObject til SELECT og send parametre med
//    public UserModel logInUser(String email, String password) {
//        String sql = "SELECT * FROM usermodel WHERE email = ? AND userPassword = ?";
//        try {
//            return jdbcTemplate.queryForObject(sql, userRowMapper(), email, password);
//        } catch (Exception e) {
//            System.out.println("Login fejlet: Bruger ikke fundet");
//            return null;
//        }
//    }

//    private Class<UserModel> userRowMapper() {
//        return (rs, rowNum) -> {
//            UserModel user = new UserModel();
//            user.setUserID(rs.getLong("userID"));
//            user.setUserName(rs.getString("userName"));
//            user.setEmail(rs.getString("email"));
//            user.setUserPassword(rs.getString("userPassword"));
//            return user;
//        };
//
//    }
}
//}
