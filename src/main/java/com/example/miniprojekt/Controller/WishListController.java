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

    @GetMapping("/create")
    public String createWishList() {
        String wishListName = "Alan til salg";
        String wishListItem = "slik";
        List<WishItemModel> wistItemList =
                new ArrayList<>(Arrays.asList(new WishItemModel(1, "Slik", "Chokolade og karameller", 50.0),
                new WishItemModel(2, "Lego", "Star Wars Lego-sæt", 899.0)
        ));
        wishListService.createWishList(wishListName, wishListItem, wistItemList);

        return "createItem";
    }
}
