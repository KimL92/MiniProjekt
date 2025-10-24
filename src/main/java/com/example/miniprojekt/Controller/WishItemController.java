package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/WishItem")
public class WishItemController {


    private WishItemService wishItemService;

    public WishItemController(WishItemService wishItemService){
        this.wishItemService = wishItemService;
    }

    // test for at se om det virkede.
    @GetMapping
    public String createWishItem(){
            String itemTitle = "hej";
            String itemDescription = "fedt";
            double itemPrice = 899;
            wishItemService.createWishItem( itemTitle, itemDescription, itemPrice);

            return "createItem";
    }

    @GetMapping("/creat")
    public String createWishItem(Model model){
        model.addAttribute("wishItem", new WishItemModel());

        return "createItem";
    }


    @PostMapping("/delete/{itemTitle}")
    public String deleteItemTitle(@PathVariable String itemTitle) {
        wishItemService.deleteItemTitle(itemTitle);
        return "redirect:/WishItem";
    }

    @PostMapping("/save")
    public String saveWishItem(@ModelAttribute WishItemModel wishItem) {
        wishItemService.saveWishItem(wishItem);
        return "redirect:/WishItem";
    }

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
//    @PostMapping("/{name}/update")
//    public String updateAttraction(@PathVariable String name,
//                                   @ModelAttribute TouristAttraction attraction) {
//        touristService.saveAttraction(attraction);
//        return "redirect:/attractions";
//    }
}
