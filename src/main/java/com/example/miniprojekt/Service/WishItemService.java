package com.example.miniprojekt.Service;

import com.example.miniprojekt.Controller.WishItemController;
import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Repository.WishItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishItemService {

    @Autowired
    private WishItemRepository wishItemRepository;

    public WishItemService  (WishItemRepository wishItemRepository){
        this.wishItemRepository = wishItemRepository;
    }

    public WishItemModel findWishItemByTitle(String itemTitle) {
        return wishItemRepository.getAllItems().stream()
                .filter(item -> item.getItemTitle().equalsIgnoreCase(itemTitle))
                .findFirst()
                .orElse(null);
    }


    public WishItemModel saveWishItem(WishItemModel wishItem) {
        return wishItemRepository.saveWishItem(wishItem);
    }

    public void deleteItemTitle(String itemTitle) {
        wishItemRepository.deleteItemTitle(itemTitle);
    }

    public void createWishItem( String itemTitle ,String itemDescription, double itemPrice){
        wishItemRepository.createWishItem(itemTitle ,itemDescription, itemPrice);
        System.out.println(itemTitle + itemDescription + itemPrice);
    }

    public List<WishItemModel> getAllItems(){
        return wishItemRepository.getAllItems();
    }


}
