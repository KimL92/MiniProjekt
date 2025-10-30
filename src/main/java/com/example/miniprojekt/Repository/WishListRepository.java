package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Model.WishListModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepository {

    private final JdbcTemplate jdbcTemplate;


    public WishListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createWishList_user(int wishListID, long userID) {
        jdbcTemplate.update("INSERT INTO user_wishlist (userID, wishListID) VALUES (?, ?)",
        userID,wishListID);

    }

    public void createWishList(String wishListName){
        jdbcTemplate.update("INSERT INTO wishList(wishListName) VALUES (?)",
        wishListName);
    }

    public void getWishListByID(WishListModel wishListModel){
       Integer wishlistID =  jdbcTemplate.queryForObject("SELECT wishlistID FROM wishlist WHERE wishlistID=?",
                Integer.class,
               wishListModel.getWishListID());
       wishListModel.setWishListID(wishlistID);
    }

}
