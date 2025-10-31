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

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishList_user(int wishListID, long userID) {
        wishListRepository.createWishList_user(wishListID,userID);
        System.out.println(wishListID + userID);
    }

    public void createWishList(String wishListName, String wishListDescription){
        wishListRepository.createWishList(wishListName, wishListDescription);
    }

    public WishListModel getWishListByID(int id) {
        return wishListRepository.findWishListByWishListID(id);
    }

    public List<WishListModel> getAllWishlists() {
        return wishListRepository.getAllWishlists();
    }

    public void deleteWishlist(int wishListID){
        wishListRepository.deleteWishlist(wishListID);
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName){
        wishListRepository.updateWishlist(wishlistID, wishlistDescription, wishlistName);
    }

    public void saveWishList(WishListModel wishListModel) {
        wishListRepository.saveWishList(wishListModel);
    }
}

