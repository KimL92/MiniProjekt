package com.example.miniprojekt.Model;

import java.util.List;

public class WishListModel {
    private int wishListID;
    private String wishListItem;
    private String wishListName;
    private String wishItemList;


    public WishListModel() {
    }

    public int getWishListID() {
        return wishListID;
    }

    public void setWishListID(int wishListID) {
        this.wishListID = wishListID;
    }

    public String getWishListItem() {
        return wishListItem;
    }

    public void setWishListItem(String wishListItem) {
        this.wishListItem = wishListItem;
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
}



