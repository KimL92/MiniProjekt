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

    @GetMapping()
    public String showAllWishlists(Model model) {
        List<WishListModel> wishlists = wishListService.getAllWishlists();
        model.addAttribute("wishlists", wishlists);
        return "wishlist";
    }

//    @GetMapping("/createwishlist")
//    public String createWishList(Model model) {
//        model.addAttribute("wishlist", new WishListModel( "", ""));
//        return "wishlist";
//    }


    @GetMapping("/createwishlist")
    public String showCreateForm(Model model) {
        model.addAttribute("wishlist", new WishListModel());
        return "createwishlist";
    }


    @PostMapping("/createwishlist")
    public String createWishList(@RequestParam String wishListName,
                                 @RequestParam String wishListDescription) {
        wishListService.createWishList(wishListName, wishListDescription);
        return "redirect:/wishlist"; // tilbage til listen
    }

    @PostMapping("/savewishlist")
    public String saveWishItem(@ModelAttribute WishListModel wishListModel) {
        wishListService.saveWishList(wishListModel);
        return "redirect:/wishlist";
    }

    @PostMapping("/delete/{id}")
    public String deleteWishlist(@PathVariable int id) {
        wishListService.deleteWishlist(id);
        return "redirect:/wishlist";
    }

//    @PostMapping("/{wishlistID}/edit")
//    public String editWishlist(
//            @PathVariable int wishlistID,
//            @RequestParam String wishlistDescription,
//            @RequestParam String wishlistName) {
//
//        wishListService.updateWishlist(wishlistID, wishlistDescription, wishlistName);
//        return "redirect:/wishlist";
//    }

    @PostMapping("/{wishlistID}/edit")
    public String showEditForm(@PathVariable int wishlistID, Model model) {
        WishListModel wishlist = wishListService.getWishListByID(wishlistID);
        model.addAttribute("wishlist", wishlist);
        return "editWishlist"; // lav en thymeleaf-side til at redigere
    }

}

