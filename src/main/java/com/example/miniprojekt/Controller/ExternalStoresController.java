package com.example.miniprojekt.Controller;


import com.example.miniprojekt.Model.ExternalStores;
import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.ExternalService;
import com.example.miniprojekt.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishitem")
public class ExternalStoresController {

    private final ExternalService externalService;

    public ExternalStoresController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/createexternalstore")
    public String createExternslStores(Model model) {
        model.addAttribute("externalstores", new ExternalStores());

        return "createItem";
    }

    //test
    @GetMapping("/createexternalstores")
    public String createExternslStores() {
        String storeName = "zara";
        String storeURL = "moha2200@stud.ek.dk";
        String storeDescription = "test123";
        String storeCategory = "flash";
        externalService.createExternslStores(storeName, storeURL, storeDescription,storeCategory );

        return "createstore";

    }

    @PostMapping("/delete/{createexternalstore}")
    public String deleteExternalStore(@RequestParam long storeID ) {
        externalService.deleteExternalStore(storeID);
        return "redirect:/wishitem";
    }

    //test " for at teste bois skal i skrive (http://localhost:8080/wishitem/delete-store?storeID=4)
    @GetMapping("/delete-store")
    public String deleteStore(@RequestParam long storeID) {
        System.out.println("Forsøger at slette store med ID: " + storeID);

        externalService.deleteExternalStore(4);

        return "redirect:/wishitem";
    }


}
