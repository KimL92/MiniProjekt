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
        jdbcTemplate.update("INSERT INTO user_wishlist (wishListID, userID) VALUES (?, ?)",
        userID,wishListID);

    }

    public void createWishList(String wishListName, String wishListDescription){
        jdbcTemplate.update("INSERT INTO wishlist (wishListName, description) VALUES (?, ?)",
        wishListName, wishListDescription);
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

    public void saveWishList(WishListModel wishListModel) {
        WishItemModel existing = findWishItemByTitle(wishListModel.getWishListName());
        if (existing != null) {
            jdbcTemplate.update("INSERT INTO wishlist(wishListName, wishListDescription) VALUES (?, ?)",
                    wishListModel.getWishListName(), wishListModel.getWishListDescription());

            Integer itemID = jdbcTemplate.queryForObject("SELECT itemID From WishItemModel WHERE itemID=? ",
                    Integer.class, wishItemModel.getItemTitle());

            wishItemModel.setItemID(itemID);
            return wishItemModel;

        }else {
            // bois herned under opretter den et nyt item
            jdbcTemplate.update("INSERT INTO wishitem(itemTitle, itemDescription ,itemPrice,itemURL) VALUES (?, ?, ?, ?)",
                    wishItemModel.getItemTitle(), wishItemModel.getItemDescription(),wishItemModel.getItemPrice(),wishItemModel.getItemURL()
            );


            // drenge hernede henter vi det nye itemID
            Integer itemID = jdbcTemplate.queryForObject("SELECT itemID FROM wishitem WHERE itemTitle=?",
                    Integer.class,
                    wishItemModel.getItemTitle()
            );

            wishItemModel.setItemID(itemID);
            return wishItemModel;

        }
    }
}






