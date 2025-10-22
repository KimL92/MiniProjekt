package com.example.miniprojekt.Model;

public class ItemList {
    private int itemId;
    private String itemTitle;
    private String itemDescription;
    private int price;


    public ItemList(int price , int id, String itemTitle, String description) {
        this.itemId = id;
        this.itemTitle = itemTitle;
        this.itemDescription = description;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(){
        this.price = price;
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

