package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishItemModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

// TODO allan kan du forklare hvad du mener from item??
    public void deleteItemTitle(String itemTitle) {
        WishItemModel existing = findWishItemByTitle(itemTitle);
        if (existing != null) {
            jdbcTemplate.update("DELETE FROM wishitem WHERE itemTitle=?", itemTitle);
        }
    }


    public WishItemModel findWishItemByTitle(String itemTitle) {
        String sql = "SELECT * FROM wishitem WHERE ?";
        List<WishItemModel> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            int itemID = rs.getInt("itemID");
            return new WishItemModel(
                    rs.getInt("itemID"),
                    rs.getString("itemTitle"),
                    rs.getString("itemDescription"),
                    rs.getInt("itemPrice"),
                    rs.getString("itemURL")
            );
        }, itemTitle);
        return list.isEmpty() ? null : list.get(0);
    }
    //

    public void createWishItem(String itemTitle, String itemDescription, double itemPrice, String itemURL) {
        jdbcTemplate.update("INSERT INTO wishitem ( itemTitle, itemDescription, itemPrice, itemURL) VALUES (?,?, ?, ?)",
        itemTitle, itemDescription,itemPrice, itemURL);
        System.out.println(itemPrice + itemTitle + itemDescription + itemURL);

    }

    public WishItemModel saveWishItem(WishItemModel wishItemModel) {
        WishItemModel existing = findWishItemByTitle(wishItemModel.getItemTitle());
        if (existing != null) {
            jdbcTemplate.update("UPDATE itemTitle SET itemDescription=?,itemPrice=? WHERE itemTitle=?",
                    wishItemModel.getItemDescription(), wishItemModel.getItemPrice(), wishItemModel.getItemTitle());

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
//BeanPropertyRowMapper - Den matcher kolonnenavne med felter i klassen - så vi ikke skal hardkode rs,rowNum;
    public List<WishItemModel> getAllItems() {
    String sql = "SELECT * FROM wishItem";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WishItemModel.class));
    }
}

