package com.example.miniprojekt.Model;


public class ExternalStores {
    private long storeID;
    private String storeName;
    private String storeURL;
    private String storeDescription;
    private String storeCategory;

    public ExternalStores(long storeID, String storeName, String storeURL, String storeDescription, String storeCategory) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeURL = storeURL;
        this.storeDescription = storeDescription;
        this.storeCategory = storeCategory;
    }

    public ExternalStores() {

    }


    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
    }

    public long getStoreID() {
        return storeID;
    }

    public void setStoreID(long storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreURL() {
        return storeURL;
    }

    public void setStoreURL(String storeURL) {
        this.storeURL = storeURL;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }
}



