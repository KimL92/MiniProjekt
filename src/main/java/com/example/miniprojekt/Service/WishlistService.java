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

    public void createWishlist(String wishlistName, String wishlistDescription){
        wishlistRepository.createWishlist(wishlistName, wishlistDescription);
    }

    public List<WishlistModel> getAllWishlists() {
        return wishlistRepository.getAllWishlists();
    }

    public void deleteWishlist(int wishlistID){
        wishlistRepository.deleteWishlist(wishlistID);
    }

    public void deleteWishlistItem(int id) {
    }

    public void saveWishlist(WishlistModel wishlistModel) {
        wishlistRepository.saveWishlist(wishlistModel);
    }

}

