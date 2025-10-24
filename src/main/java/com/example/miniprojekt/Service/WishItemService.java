package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Repository.WishItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishItemService {

    @Autowired
    private WishItemRepository wishItemRepository;

    public WishItemService  (WishItemRepository wishItemRepository){
        this.wishItemRepository = wishItemRepository;
    }


    public WishItemModel saveWishItem(WishItemModel wishItem) {
        return wishItemRepository.saveWishItem(wishItem);
    }

    public void deleteItemTitle(String itemTitle) {
        wishItemRepository.deleteItemTitle(itemTitle);
    }

    public void createWishItem(int itemId, String itemTitle ,String itemDescription, int itemPrice){
        wishItemRepository.createWishItem(itemId, itemTitle ,itemDescription, itemPrice);
    }


}
