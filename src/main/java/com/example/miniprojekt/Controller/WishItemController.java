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

    //


    // TODO vi skal få lavet den sidste endpoint i Denne her Controller - det er edit - husk os at at kigge på repo og service-
    //  fra mohamed. husk skrive noter så vi kan forklare det til hinanden. god weekend.

//    @GetMapping("/{name}/edit")
//    public String showEditForm(@PathVariable String name, Model model) {
//        TouristAttraction attraction = touristService.findTouristAttractionByName(name);
//        if (attraction == null) {
//            return "redirect:/attractions";
//        }
//
//        model.addAttribute("attraction", attraction);
//        model.addAttribute("cities", touristService.getAllLocations()); // liste af byer
//        model.addAttribute("tags", touristService.getAllTags());        // liste af tags
//
//        return "updateAttraction";
//    }
//

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


