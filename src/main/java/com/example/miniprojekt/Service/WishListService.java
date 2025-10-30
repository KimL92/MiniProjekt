package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Model.WishListModel;
import com.example.miniprojekt.Repository.WishListRepository;
import com.sun.jdi.ArrayReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {


    private final WishListRepository wishListRepository;
    private final WishItemService wishItemService;


    public WishListService(WishListRepository wishListRepository, WishItemService wishItemService) {
        this.wishListRepository = wishListRepository;
        this.wishItemService = wishItemService;
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
        return wishListRepository.findWishListByWishListID(id); // smid evt. try/catch eller lav Optional hvis I vil håndtere 'ikke fundet'
    }

//    public void deleteWishlist(String wishlistName) {
//         wishListRepository.deleteWishlist(wishlistName);
//
//    }

    public void deleteWishlist(int wishListID, String wishlistDescription, String wishlistName){
        wishListRepository.deleteWishlist(wishListID,wishlistDescription, wishlistName);
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName){
        wishListRepository.updateWishlist(wishlistID, wishlistDescription, wishlistName);

    }




}





//    public void deleteItemTitle(String itemTitle) {
//        WishItemRepository.deleteItemTitle(itemTitle);
//    }
//
//}
