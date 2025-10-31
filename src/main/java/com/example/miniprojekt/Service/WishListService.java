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

    public List<WishListModel> getAllWishlists() {
        return wishListRepository.getAllWishlists();
    }

    public WishListModel getWishListByID(int id) {
        return wishListRepository.findWishListByWishListID(id);
    }

    public void createWishList(String name) {
        wishListRepository.createWishList(name);
    }

    public void deleteWishlist(int id) {
        wishListRepository.deleteWishlist(id);
    }

    public void updateWishlist(int id, String description, String name) {
        wishListRepository.updateWishlist(id, description, name);
    }
}
