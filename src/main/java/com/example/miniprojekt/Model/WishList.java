package com.example.miniprojekt.Model;

public class WishList {
    private int itemId;
    private String itemTitle;
    private String itemDescription;

    public WishList(int id, String itemTitle, String description) {
        this.itemId = id;
        this.itemTitle = itemTitle;
        this.itemDescription = description;
    }

    public int getItemId() {
        return itemId;
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

