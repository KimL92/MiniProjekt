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

    public WishListModel findWishListByWishListID(int wishListId) {
        String sql = "SELECT wishListId, wishListName, description FROM wishlist WHERE wishListId = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new WishListModel(
                rs.getInt("wishListId"),
                rs.getString("wishListName"),
                rs.getString("description")
        ), wishListId);
    }

    public List<WishListModel> getAllWishlists() {
        String sql = "SELECT * FROM wishlist";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new WishListModel(
                rs.getInt("wishListId"),
                rs.getString("wishListName"),
                rs.getString("description")
        ));
    }


    public void deleteWishlist(int wishListID) {
        jdbcTemplate.update("DELETE FROM wishlist WHERE wishListId = ?", wishListID);
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName) {
        jdbcTemplate.update(
                "UPDATE wishlist SET wishlistName = ?, description = ? WHERE wishListId = ?",
                wishlistName, wishlistDescription, wishlistID
        );
    }

}






