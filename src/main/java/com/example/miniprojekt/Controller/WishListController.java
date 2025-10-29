package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/wishitem")

public class WishListController {

    private final WishListService wishListService;


    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    //test
    @GetMapping("/createwishlist")
    public String createWishList(Model model) {
        model.addAttribute("wishlistitem", new WishItemModel());
        return "wishlists";

    }
// test
//    @GetMapping("/createwishlistt")
//    public String createWishList() {
//        int wishListName = "Alan til salg";
//        wishListService.createWishList(wishListName);
//
//        return "createItem";
//    }


    @PostMapping
    public String createWishList(@RequestParam long userID, @RequestParam String wishListName) {
        int wishListID = 22;
        wishListService.createWishList(wishListName);
        wishListService.createWishList_user(wishListID, userID);

        wishListService.getWishListByID(wishListID);
        return "createItem";
    }

    @GetMapping("/ID/{wishlistID}")
    public String getWishListByID(@PathVariable int wishlistID){
        int wishlistIDtest= 6;
        wishListService.getWishListByID(wishlistIDtest);
        return "getWishListByID";
    }

}

