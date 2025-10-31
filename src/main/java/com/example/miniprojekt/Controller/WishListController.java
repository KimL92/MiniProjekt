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
@RequestMapping("/wishlist")

public class WishListController {

    private final WishListService wishListService;


    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    //test
    @GetMapping("/createwishlist")
    public String createWishList(Model model) {
        model.addAttribute("wishlistitem", new WishItemModel());
        return "wishlist";

    }



 // shababs problemet er her, at vi hardkoder ID'et ind her. Det skal vi ikke. Vi kan ikke vide, hvilket produkt som
    // brugeren gerne vil ind på. det er ikke altid 22 jo.
    @PostMapping("/createwishlist")
    public String createWishList(@RequestParam long userID, @RequestParam String wishListName) {
        int wishListID = 22;
        wishListService.createWishList(wishListName);
        wishListService.createWishList_user(wishListID, userID);

        return "wishlist";
    }

    @GetMapping()
    public String showAllWishlists(Model model) {
        List<WishListModel> wishlists = wishListService.getAllWishlists();
        model.addAttribute("wishlists", wishlists);
        return "wishlist";
    }

    @PostMapping("/delete/{id}")
    public String deleteWishlist(@PathVariable int id) {
        wishListService.deleteWishlist(id);
        return "redirect:/wishlist";
    }

    @PostMapping("/{wishlistID}/edit")
    public String editWishlist(
            @PathVariable int wishlistID,
            @RequestParam String wishlistDescription,
            @RequestParam String wishlistName) {

        wishListService.updateWishlist(wishlistID, wishlistDescription, wishlistName);
        return "redirect:/wishlist";
    }

    @GetMapping("/{wishlistID}/edit")
    public String showEditForm(@PathVariable int wishlistID, Model model) {
        WishListModel wishlist = wishListService.getWishListByID(wishlistID);
        model.addAttribute("wishlist", wishlist);
        return "editWishlist"; // lav en thymeleaf-side til at redigere
    }

}

