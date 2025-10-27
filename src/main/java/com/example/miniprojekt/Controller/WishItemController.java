package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wishitem")
public class WishItemController {


    private final WishItemService wishItemService;

    public WishItemController(WishItemService wishItemService) {
        this.wishItemService = wishItemService;
    }

    // test for at se om det virkede.
    @GetMapping("/create")
    public String createWishItem() {
        String itemTitle = "hej";
        String itemDescription = "fedt";
        double itemPrice = 899;
        wishItemService.createWishItem(itemTitle, itemDescription, itemPrice);

        return "createItem";
    }

    // rigtige metode
    @GetMapping("/createitem")
    public String createWishItem(Model model) {
        model.addAttribute("wishItem", new WishItemModel());

        return "createItem";
    }

    @PostMapping("/save")
    public String saveWishItem(@ModelAttribute WishItemModel wishItem) {
        wishItemService.saveWishItem(wishItem);
        return "redirect:/WishItem";
    }

    @GetMapping("/all")
    public String showAllItems(Model model) {
        List<WishItemModel> items = wishItemService.getAllItems();
        model.addAttribute("items", items);

        return "viewItems"; // vi skal lave en html til det
    }

    @PostMapping("/delete/{itemTitle}")
    public String deleteItemTitle(@PathVariable String itemTitle) {
        wishItemService.deleteItemTitle(itemTitle);
        return "redirect:/WishItem/all";
    }


    @PostMapping("/{name}/update")
    public String updateItem(@PathVariable String itemTitle, @ModelAttribute WishItemModel wishItem) {
        wishItemService.saveWishItem(wishItem);
        return "redirect:/attractions/all";
    }

    @GetMapping("/{name}/edit")
    public String showEditWishItem(@PathVariable String name, Model model) {
        WishItemModel item = wishItemService.findWishItemByTitle(name);
        if (item == null) {
            return "redirect:/WishItem/all";
        }
        model.addAttribute("wishItem", item);
        return "editItem";
        }
    }


