package com.example.miniprojekt.Model;

public class WishItemModel {
    private Integer itemId;
    private String itemTitle;
    private String itemDescription;
    private double itemPrice;

    public WishItemModel(){

    }

    public WishItemModel( Integer itemId, String itemTitle, String itemDescription, double itemPrice ) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }

    public void setItemId(Integer itemId){
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

