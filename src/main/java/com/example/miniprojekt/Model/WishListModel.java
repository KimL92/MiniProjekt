package com.example.miniprojekt.Model;

import java.util.List;

public class WishListModel {
    private int wishListID;
    private String wishListItem;
    private String wishListName;
    private List<WishItemModel> wishItemList;


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

    public List<WishItemModel> getWishItemList() {
        return wishItemList;
    }

    public void setWishItemList(List<WishItemModel> wishItemList) {
        this.wishItemList = wishItemList;
    }
}



