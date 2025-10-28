package com.example.miniprojekt.Model;

public class WishItemModel {
    private Integer itemID;
    private String itemTitle;
    private String itemDescription;
    private double itemPrice;

    public WishItemModel(){

    }

    public WishItemModel( Integer itemID, String itemTitle, String itemDescription, double itemPrice ) {
        this.itemID = itemID;
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public Integer getItemID() {
        return itemID;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }

    public void setItemID(Integer itemID){
        this.itemID = itemID;
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

