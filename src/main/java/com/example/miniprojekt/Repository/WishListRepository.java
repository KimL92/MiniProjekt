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

    // sindssyg metode shabab
    public WishListModel findWishListByWishListID(int wishListId) {
        String sql = "SELECT wishListId, wishListName, description FROM wishlist WHERE wishListId = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rn) -> {
            WishListModel m = new WishListModel();
            m.setWishListID(rs.getInt("wishListId"));
            m.setWishListName(rs.getString("wishListName"));
            m.setWishListDescription(rs.getString("description")); // burde ændre navnet her til wishlistdescription
            return m;
        }, wishListId);
    }

    // Henter alle ønskelister
    public List<WishListModel> getAllWishlists() {
        String sql = "SELECT * FROM wishlist";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new WishListModel(
                rs.getInt("wishListId"),
                rs.getString("wishListName"),
                rs.getString("description")
        ));
    }

    public void deleteWishlist(int wishListID) {
        String sql = "DELETE FROM wishlist WHERE wishListId = ?";
        jdbcTemplate.update(sql, wishListID);
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName) {
        jdbcTemplate.update(
                "UPDATE wishlist SET wishlistName = ?, description = ? WHERE wishListId = ?",
                wishlistName, wishlistDescription, wishlistID
        );
    }

}


