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

    // lad denne blive, den giver ikke mening.
//    public Integer getWishListByID(int wishlistID){
//       return jdbcTemplate.queryForObject("SELECT wishlistID FROM wishlist WHERE wishlistID = ?",
//                Integer.class,
//               wishlistID
//                       );
//    }

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

//    public void deleteWishlist(String wishListName) {
//        jdbcTemplate.update("DELETE FROM wishlist WHERE wishListName = ?", wishListName);
//    }

    public void deleteWishlist(int wishListID, String wishlistDescription, String wishlistName) {
        jdbcTemplate.update("DELETE FROM wishlist WHERE (wishListId, wishlistDescription, wishlistName) = ?, ?, ?",
                wishListID, wishlistDescription, wishlistName);
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName) {
        jdbcTemplate.update(
                "UPDATE wishlist SET wishlistName = ?, description = ? WHERE wishListId = ?",
                wishlistName, wishlistDescription, wishlistID
        );
    }

}


