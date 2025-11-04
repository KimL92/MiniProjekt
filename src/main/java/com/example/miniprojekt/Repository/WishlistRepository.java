package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishlistModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createWishlist_user(int wishlistID, long userID) {
        jdbcTemplate.update("INSERT INTO user_wishlist (wishlist_id, user_id) VALUES (?, ?)",
        userID,wishlistID);
    }

    public void createWishlist(String wishlistName, String wishlistDescription){
        jdbcTemplate.update("INSERT INTO wishlist (wishlist_name, wishlist_description) VALUES (?, ?)",
        wishlistName, wishlistDescription);
    }

    public WishlistModel findWishlistByWishlistID(int wishlistId) {
        String sql = "SELECT wishlist_id, wishlist_name, wishlist_description FROM wishlist WHERE wishlist_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new WishlistModel(
                rs.getInt("wishlist_id"),
                rs.getString("wishlist_name"),
                rs.getString("wishlist_description")
        ), wishlistId);
    }

    public List<WishlistModel> getAllWishlists() {
        String sql = "SELECT * FROM wishlist";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new WishlistModel(
                rs.getInt("wishlist_id"),
                rs.getString("wishlist_name"),
                rs.getString("wishlist_description")
        ));
    }

    public void deleteWishlist(int wishlistID) {
        jdbcTemplate.update("DELETE FROM wishlist WHERE wishlist_id = ?", wishlistID);
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName) {
        jdbcTemplate.update(
                "UPDATE wishlist SET wishlist_name = ?, wishlist_description = ? WHERE wishlist_id = ?",
                wishlistName, wishlistDescription, wishlistID
        );
    }

    public void saveWishlist(WishlistModel wishlistModel) {
        String sql = "INSERT INTO wishlist (wishlist_name, wishlist_description) VALUES (?, ?)";

        jdbcTemplate.update(sql,
                wishlistModel.getWishlistName(),
                wishlistModel.getWishlistDescription()
        );
    }
}






