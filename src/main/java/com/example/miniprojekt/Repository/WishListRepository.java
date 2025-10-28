package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishItemModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepository {

    private final JdbcTemplate jdbcTemplate;


    public WishListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createWishList(String wishListName) {
        jdbcTemplate.update("INSERT INTO wishlistmodel (wishListName) VALUES (?)",
                wishListName);

    }
}
