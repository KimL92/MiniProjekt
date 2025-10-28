package com.example.miniprojekt.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExternalRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExternalRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createExternslStores(String storeName, String storeURL, String storeDescription, String storeCategory) {
        jdbcTemplate.update("INSERT INTO externalStores(storeName,storeURL, storeDescription, storeCategory) VALUES (?, ?, ?, ?)",
                storeName, storeURL, storeDescription,storeCategory);
        System.out.println(storeName + storeURL + storeDescription + storeCategory);
    }

    public void deleteExternalStore(long storeID) {
        String sql = "DELETE FROM externalstores WHERE storeID = ?";
        int rowsAffected = jdbcTemplate.update(sql, storeID);

        if (rowsAffected > 0) {
            System.out.println("Store slettet med ID: " + storeID);
        } else {
            System.out.println("Ingen store fundet med ID: " + storeID);
        }
    }
}
