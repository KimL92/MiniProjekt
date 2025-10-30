package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Model.WishListModel;
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

 // shababs problemet er her, at vi hardkoder ID'et ind her. Det skal vi ikke. Vi kan ikke vide, hvilket produkt som
    // brugeren gerne vil ind på. det er ikke altid 22 jo.
    @PostMapping
    public String createWishList(@RequestParam long userID, @RequestParam String wishListName) {
        int wishListID = 22;
        wishListService.createWishList(wishListName);
        wishListService.createWishList_user(wishListID, userID);

        wishListService.getWishListByID(wishListID);
        return "createItem";
    }

//    @GetMapping("/ID/{wishlistID}")
//    public String getWishListByID(@PathVariable int wishlistID){
//        int wishlistIDtest= 6;
//        wishListService.getWishListByID(wishlistIDtest);
//        return "getWishListByID";
//    }
//
//    @GetMapping("/ID")
//    public String getWishListByID(@RequestParam int ID, Model model) {
//        Integer wishlistFound = wishListService.getWishListByID(ID);
//        model.addAttribute("wishlistFound", wishlistFound);
//        return "getWishListByID"; // navnet på HTML-siden
//    }

    // det her shabas er med requestparam så url skrives som på linje 70
    // GET /wishlist?id=6
//    @GetMapping
//    public String getWishListByID(@RequestParam int id, Model model) {
//        WishListModel wishlist = wishListService.getWishListByID(id);
//        model.addAttribute("wishlist", wishlist);
//        return "wishlistView"; // fx templates/wishlistView.html
//    }

    // eller så er der her med pathvariable:
    // GET /wishlist/6
    @GetMapping("/viewWishlist/{id}")
    public String getWishListByID(@PathVariable int id, Model model) {
        WishListModel wishlist = wishListService.getWishListByID(id);
        model.addAttribute("wishlist", wishlist);
        return "wishlistView";
    }

}

