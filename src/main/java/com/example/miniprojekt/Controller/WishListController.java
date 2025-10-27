package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/wishitem")

public class WishListController {

    private final WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping("/createwishlist")
    public String createWishList(Model model) {
        model.addAttribute("wishlistitem", new WishItemModel());
        return "wishlists";

    }
// test
    @GetMapping("/createwishlistt")
    public String createWishList() {
        String wishListName = "Alan til salg";
        wishListService.createWishList(wishListName);

        return "createItem";
    }
}
