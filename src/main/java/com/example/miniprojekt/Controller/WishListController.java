package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishListModel;
import com.example.miniprojekt.Service.WishListService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/delete/{id}")
    public String deleteWishlist(@PathVariable int id) {
        wishListService.deleteWishlist(id);
        return "redirect:/wishlist";
    }



    // slet når hjemmeside færdig
    @PostConstruct
    public void testController() {
        System.out.println("✅ WishListController is active!");
    }
}
