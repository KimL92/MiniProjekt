package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {


    private final WishListRepository wishListRepository;


    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }
    public void createWishList(String wishListItem, String wishListName, List<WishItemModel> wishItemList) {
        wishListRepository.createWishList(wishListName, wishItemList, wishListItem);
        System.out.println(wishListName + wishItemList + wishListItem);
    }
}








//    public void deleteItemTitle(String itemTitle) {
//        WishItemRepository.deleteItemTitle(itemTitle);
//    }
//
//}
