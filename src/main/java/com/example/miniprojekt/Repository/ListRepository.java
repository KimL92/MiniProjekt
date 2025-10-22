package com.example.miniprojekt.Repository;

public class ListRepository {


    public void deleteItemTitle(String itemTitle) {
        TouristAttraction existing = findTouristAttractionByName(name);
        if (existing != null) {
            jdbcTemplate.update("DELETE FROM attraction WHERE name=?", name);
        }
    }
}
