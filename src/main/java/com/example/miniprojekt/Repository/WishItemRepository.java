package com.example.miniprojekt.Repository;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Model.WishListModel;

import java.util.List;

public class WishItemRepository {


    public void deleteItemTitle(String itemTitle) {
        WishItemModel existing = findWishItemByTitle(itemTitle);
        if (existing != null) {
            jdbcTemplate.update("DELETE FROM item WHERE itemTitle=?", itemTitle);
        }
    }


    public WishItemModel findWishItemByTitle(String itemTitle) {
        String sql = "SELECT * FROM attraction WHERE LOWER(name)=LOWER(?)";
        List<TouristAttraction> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            int id = rs.getInt("id");
            return new TouristAttraction(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("location"),
                    getTouristAttractionTags(id)
            );
        }, name);
        return list.isEmpty() ? null : list.get(0);
    }
}

