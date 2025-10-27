package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.WishItemRepository;
import com.example.miniprojekt.Repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ListService {

    @Autowired
    private WishListRepository wishListRepository;


    public ListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }
}









//    public void deleteItemTitle(String itemTitle) {
//        WishItemRepository.deleteItemTitle(itemTitle);
//    }
//
//}
