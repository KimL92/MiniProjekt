package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;


    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }
}









//    public void deleteItemTitle(String itemTitle) {
//        WishItemRepository.deleteItemTitle(itemTitle);
//    }
//
//}
