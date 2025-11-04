package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/wishitem")
public class WishItemController {

    private final WishItemService wishItemService;

    public WishItemController(WishItemService wishItemService) {
        this.wishItemService = wishItemService;
    }

    @GetMapping("/list/{wishlistId}")
    public String showItemsForWishlist(@PathVariable int wishlistId, Model model) {
        // Hent alle items der hører til denne ønskeliste
        List<WishItemModel> items = wishItemService.getItemsByWishlistId(wishlistId);

        model.addAttribute("items", items);
        model.addAttribute("wishlistId", wishlistId);

        return "wishlistItems";
    }

    @PostMapping("/createitem")
    public String createWishItem(@RequestParam String itemTitle,
                                 @RequestParam String itemDescription,
                                 @RequestParam String itemURL,
                                 @RequestParam double itemPrice,
                                 @RequestParam int wishlistId) {
        wishItemService.createWishItemForWishlist(wishlistId, itemTitle, itemDescription, itemPrice, itemURL);
        return "redirect:/wishitem/list/" + wishlistId;
    }

    @PostMapping("/save")
    public String saveWishItem(@ModelAttribute WishItemModel wishItem) {
        wishItemService.saveWishItem(wishItem);
        return "redirect:/wishItem";
    }

    @PostMapping("/delete")
    public String deleteItemByItemID(@RequestParam int itemID, @RequestParam int wishlistId) {
        wishItemService.deleteItemByItemID(itemID);
        return "redirect:/wishitem/list/" + wishlistId;
    }

    @PostMapping("/{name}/update")
    public String updateItem(@PathVariable String itemTitle, @ModelAttribute WishItemModel wishItem) {
        wishItemService.saveWishItem(wishItem);
        return "redirect:/wishlist";
    }

    @GetMapping("/{name}/edit")
    public String showEditWishItem(@PathVariable String name, Model model) {
        WishItemModel item = wishItemService.findWishItemByTitle(name);
        if (item == null) {
            return "redirect:/wishlist";
        }
        model.addAttribute("wishItem", item);
        return "editItem";
        }
    }


