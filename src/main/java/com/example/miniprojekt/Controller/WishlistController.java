package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishlistModel;
import com.example.miniprojekt.Service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/wishlist")

public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping()
    public String showAllWishlists(Model model) {
        List<WishlistModel> wishlists = wishlistService.getAllWishlists();
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
        model.addAttribute("wishlist", new WishlistModel());
        return "createwishlist";
    }

    @PostMapping("/createwishlist")
    public String createWishList(@RequestParam String wishlistName, @RequestParam String wishlistDescription) {
        wishlistService.createWishlist(wishlistName, wishlistDescription);
        return "redirect:/wishlist"; // tilbage til listen
    }

    @PostMapping("/savewishlist")
    public String saveWishList(@ModelAttribute WishlistModel wishListModel) {
        wishlistService.saveWishlist(wishListModel);
        return "redirect:/wishlist";
    }

    @PostMapping("/delete/{id}")
    public String deleteWishlist(@PathVariable int id) {
        wishlistService.deleteWishlist(id);
        return "redirect:/wishlist";
    }

    @PostMapping("/deleteitem/{id}")
    public String deleteWishlistItem(@PathVariable int id) {
        wishlistService.deleteWishlistItem(id);
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
        WishlistModel wishlist = wishlistService.getWishlistByID(wishlistID);
        model.addAttribute("wishlist", wishlist);
        return "editWishlist"; // lav en thymeleaf-side til at redigere
    }

}

