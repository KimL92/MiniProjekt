package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Service.WishItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/WishItem")
public class WishItemController {

    private WishItemService wishItemService;

    public WishItemController(WishItemService wishItemService){
        this.wishItemService = wishItemService;
    }

    @GetMapping
    public String createWishItem(){
            int id = 1;
            String itemTitle = "hej";
            String itemDescription = "fedt";
            int itemPrice = 899;
            return "createitem";
    }
}
