package com.example.miniprojekt.Model;

public class WishListModel {
    private int wishListID;
    private String wishListName;
    private String wishListDescription;

    public WishListModel() {}

    public WishListModel(int wishListID, String wishListName, String wishListDescription) {
        this.wishListID = wishListID;
        this.wishListName = wishListName;
        this.wishListDescription = wishListDescription;
    }

    // Getters & setters
    public int getWishListID() { return wishListID; }
    public void setWishListID(int wishListID) { this.wishListID = wishListID; }

    public String getWishListName() { return wishListName; }
    public void setWishListName(String wishListName) { this.wishListName = wishListName; }

    public String getWishListDescription() { return wishListDescription; }
    public void setWishListDescription(String wishListDescription) { this.wishListDescription = wishListDescription; }
}
