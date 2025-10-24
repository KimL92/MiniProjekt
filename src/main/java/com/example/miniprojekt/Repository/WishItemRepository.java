package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishItemModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void deleteItemTitle(String itemTitle) {
        WishItemModel existing = findWishItemByTitle(itemTitle);
        if (existing != null) {
            jdbcTemplate.update("DELETE FROM item WHERE itemTitle=?", itemTitle);
        }
    }


    public WishItemModel findWishItemByTitle(String itemTitle) {
        String sql = "SELECT * FROM wishItem WHERE ?";
        List<WishItemModel> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            int itemId = rs.getInt("itemId");
            return new WishItemModel(
                    rs.getInt("itemId"),
                    rs.getString("itemTitle"),
                    rs.getString("itemDescription"),
                    rs.getInt("itemPrice")
            );
        }, itemTitle);
        return list.isEmpty() ? null : list.get(0);
    }
    //

    public void createWishItem(int itemId, String itemTitle, String itemDescription, int itemPrice) {
        jdbcTemplate.update("INSERT INTO wishItem (itemId, itemTitle, itemDescription, itemPrice) VALUES (?, ?, ?,?)");

    }

    public WishItemModel saveWishItem(WishItemModel wishItemModel) {
        WishItemModel existing = findWishItemByTitle(wishItemModel.getItemTitle());
        if (existing != null) {
            jdbcTemplate.update("UPDATE itemTitle SET itemDescription=?,itemPrice=? WHERE itemTitle",
                    wishItemModel.getItemDescription(), wishItemModel.getItemPrice(), wishItemModel.getItemTitle());

            Integer itemId = jdbcTemplate.queryForObject("SELECT itemId From WishItemModel WHERE itemId=? ",
                    Integer.class, wishItemModel.getItemTitle());

            wishItemModel.setItemId(itemId);
            return wishItemModel;

        }else {
            // bois hernedunder   opretter den et nyt item
            jdbcTemplate.update("INSERT INTO WishiItemModel(itemTitle, itemDescription ,itemPrice) VALUES (?, ?, ?)",
            wishItemModel.getItemTitle(), wishItemModel.getItemDescription(),wishItemModel.getItemPrice()
            );


            // drenge hernede henter vi det nye itemId
            Integer itemId = jdbcTemplate.queryForObject("SELECT itemId FROM WishItemModel WHERE itemTitle=?",
                    Integer.class,
                    wishItemModel.getItemTitle()
            );

            wishItemModel.setItemId(itemId);
            return wishItemModel;

        }
    }
}

