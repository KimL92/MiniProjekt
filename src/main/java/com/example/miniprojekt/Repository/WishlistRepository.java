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

//
//    public void saveWishList(WishListModel wishListModel) {
//        WishItemModel existing = findWishItemByTitle(wishListModel.getWishListName());
//        if (existing != null) {
//            jdbcTemplate.update("INSERT INTO wishlist(wishListName, wishListDescription) VALUES (?, ?)",
//                    wishListModel.getWishListName(), wishListModel.getWishListDescription());
//
//            Integer itemID = jdbcTemplate.queryForObject("SELECT itemID From WishItemModel WHERE itemID=? ",
//                    Integer.class, wishItemModel.getItemTitle());
//
//            wishItemModel.setItemID(itemID);
//            return wishItemModel;
//
//        }else {
//            // bois herned under opretter den et nyt item
//            jdbcTemplate.update("INSERT INTO wishitem(itemTitle, itemDescription ,itemPrice,itemURL) VALUES (?, ?, ?, ?)",
//                    wishItemModel.getItemTitle(), wishItemModel.getItemDescription(),wishItemModel.getItemPrice(),wishItemModel.getItemURL()
//            );
//
//
//            // drenge hernede henter vi det nye itemID
//            Integer itemID = jdbcTemplate.queryForObject("SELECT itemID FROM wishitem WHERE itemTitle=?",
//                    Integer.class,
//                    wishItemModel.getItemTitle()
//            );
//
//            wishItemModel.setItemID(itemID);
//            return wishItemModel;
//
//        }
//    }
}






