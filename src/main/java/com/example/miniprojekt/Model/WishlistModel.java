package com.example.miniprojekt.Model;

public class WishlistModel {
    private int wishlistID;
    private String wishlistName;
    private String wishlistDescription;

    public WishlistModel() {
    }

    public WishlistModel(String wishlistName, String wishlistDescription) {
        this.wishlistName = wishlistName;
        this.wishlistDescription = wishlistDescription;
    }

    public WishlistModel(int wishlistID, String wishlistName, String wishlistDescription) {
        this.wishlistID = wishlistID;
        this.wishlistName = wishlistName;
        this.wishlistDescription = wishlistDescription;
    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public String getWishlistDescription() {
        return wishlistDescription;
    }

    public void setWishlistDescription(String wishlistDescription) {
        this.wishlistDescription = wishlistDescription;
    }
}



