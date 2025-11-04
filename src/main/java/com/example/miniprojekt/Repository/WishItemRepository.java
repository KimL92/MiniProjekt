package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishItemModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class WishItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteItemByItemID(int itemID) {
        WishItemModel existing = findWishItemByItemID(itemID);
        if (existing != null) {
            jdbcTemplate.update("DELETE FROM wishitem WHERE item_id=?", itemID);
        }
    }

    public WishItemModel findWishItemByTitle(String itemTitle) {
        String sql = "SELECT * FROM wishitem WHERE item_title = ?";

        List<WishItemModel> list = jdbcTemplate.query(sql, (rs, rowNum) ->
                new WishItemModel(
                        rs.getInt("item_id"),
                        rs.getString("item_title"),
                        rs.getString("item_description"),
                        rs.getDouble("item_price"),
                        rs.getString("item_url")
                ), itemTitle);

        return list.isEmpty() ? null : list.get(0);
    }

    public WishItemModel findWishItemByItemID(int itemID) {
        String sql = "SELECT * FROM wishitem WHERE item_id = ?";

        List<WishItemModel> list = jdbcTemplate.query(sql, (rs, rowNum) ->
                new WishItemModel(
                        rs.getInt("item_id"),
                        rs.getString("item_title"),
                        rs.getString("item_description"),
                        rs.getDouble("item_price"),
                        rs.getString("item_url")
                ), itemID);

        return list.isEmpty() ? null : list.get(0);
    }

    public void createWishItem(String itemTitle, String itemDescription, double itemPrice, String itemURL) {
        jdbcTemplate.update("INSERT INTO wishitem ( itemTitle, itemDescription, itemPrice, itemURL) VALUES (?,?, ?, ?)",
        itemTitle, itemDescription,itemPrice, itemURL);
        System.out.println(itemPrice + itemTitle + itemDescription + itemURL);
    }

    public WishItemModel saveWishItem(WishItemModel wishItemModel) {
        WishItemModel existing = findWishItemByTitle(wishItemModel.getItemTitle());
        if (existing != null) {
            jdbcTemplate.update(
                    "UPDATE wishitem SET itemDescription=?, itemPrice=?, itemURL=? WHERE itemTitle=?",
                    wishItemModel.getItemDescription(),
                    wishItemModel.getItemPrice(),
                    wishItemModel.getItemURL(),
                    wishItemModel.getItemTitle()
            );

            Integer itemID = jdbcTemplate.queryForObject("SELECT itemID From wishItem WHERE itemID=? ",
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
//BeanPropertyRowMapper - Den matcher kolonnenavne med felter i klassen - så vi ikke skal hardkode rs,rowNum;
    public List<WishItemModel> getAllItems() {
    String sql = "SELECT * FROM wishItem";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WishItemModel.class));
    }

    public List<WishItemModel> getItemsByWishlistId(int wishlistId) {
        String sql = "SELECT item_id AS itemID, item_title AS itemTitle, item_description AS itemDescription, " +
                "item_price AS itemPrice, item_url AS itemURL, wishlist_id AS wishlistID " +
                "FROM wishitem WHERE wishlist_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WishItemModel.class), wishlistId);
    }

    public void createWishItemForWishlist(int wishlistId, String title, String description, double price, String url) {
        String sql = "INSERT INTO wishitem (wishlist_id, item_title, item_description, item_price, item_url) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, wishlistId, title, description, price, url);
    }
}

