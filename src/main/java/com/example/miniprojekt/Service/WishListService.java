package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Model.WishListModel;
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
    public void createWishList_user(int wishListID, long userID) {
        wishListRepository.createWishList_user(wishListID,userID);
        System.out.println(wishListID + userID);
    }
    public void createWishList(String wishListName){
        wishListRepository.createWishList(wishListName);

    }

//    public Integer getWishListByID(int wishListID) {
//      return wishListRepository.getWishListByID(wishListID)
//      }

    public WishListModel getWishListByID(int id) {
        return wishListRepository.findByID(id); // smid evt. try/catch eller lav Optional hvis I vil håndtere 'ikke fundet'
    }
    }








//    public void deleteItemTitle(String itemTitle) {
//        WishItemRepository.deleteItemTitle(itemTitle);
//    }
//
//}
