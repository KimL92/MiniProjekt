package com.example.miniprojekt.Model;

import java.util.List;

public class WishListModel {
    private int wishListID;
    private String wishListName;
    private String wishItemList;
    private String wishListDescription;


    public WishListModel() {
    }

    public WishListModel(String wishListName, String wishListDescription) {
        this.wishListName = wishListName;
        this.wishListDescription = wishListDescription;
    }

    public WishListModel(int wishListID, String wishListName, String wishListDescription) {
        this.wishListID = wishListID;
        this.wishListName = wishListName;
        this.wishListDescription = wishListDescription;
    }

    public int getWishListID() {
        return wishListID;
    }

    public void setWishListID(int wishListID) {
        this.wishListID = wishListID;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public String getWishItemList() {
        return wishItemList;
    }

    public void setWishItemList(String wishItemList) {
        this.wishItemList = wishItemList;
    }

    public String getWishListDescription() {
        return wishListDescription;
    }

    public void setWishListDescription(String wishListDescription) {
        this.wishListDescription = wishListDescription;
    }
}



