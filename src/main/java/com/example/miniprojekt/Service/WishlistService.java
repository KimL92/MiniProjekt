package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.WishlistModel;
import com.example.miniprojekt.Repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void createWishlist_user(int wishlistID, long userID) {
        wishlistRepository.createWishlist_user(wishlistID,userID);
        System.out.println(wishlistID + userID);
    }

    public void createWishlist(String wishlistName, String wishlistDescription){
        wishlistRepository.createWishlist(wishlistName, wishlistDescription);
    }

    public WishlistModel getWishlistByID(int id) {
        return wishlistRepository.findWishlistByWishlistID(id);
    }

    public List<WishlistModel> getAllWishlists() {
        return wishlistRepository.getAllWishlists();
    }

    public void deleteWishlist(int wishlistID){
        wishlistRepository.deleteWishlist(wishlistID);
    }

    public void deleteWishlistItem(int id) {
    }

    public void updateWishlist(int wishlistID, String wishlistDescription, String wishlistName){
        wishlistRepository.updateWishlist(wishlistID, wishlistDescription, wishlistName);
    }

    public void saveWishlist(WishlistModel wishlistModel) {
        wishlistRepository.saveWishlist(wishlistModel);
    }

}

