package com.example.miniprojekt.Model;

public class WishItemModel {
    private int itemId;
    private String itemTitle;
    private String itemDescription;
    private int itemPrice;

    public WishItemModel(int price , int id, String itemTitle, String description) {
        this.itemId = id;
        this.itemTitle = itemTitle;
        this.itemDescription = description;
        this.itemPrice = price;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemPrice(){
        return itemPrice;
    }

    public void setPrice(){
        this.itemPrice = itemPrice;
    }

    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


}

//

