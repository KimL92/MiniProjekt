package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registerpage")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // rigtige metode
    @GetMapping()
    public String createUser(Model model) {
        model.addAttribute("user", new UserModel());
        return "register-user";
    }

    @PostMapping()
    public String createUserPost(@ModelAttribute UserModel user, Model model) {
        System.out.println("Forsøger at oprette bruger: " + user.getEmail());

        boolean success = userService.createUser(user.getUserName(), user.getEmail(), user.getUserPassword());

        if (!success) {
            System.out.println("Oprettelse fejlede - viser error");
            model.addAttribute("error", "Denne email er allerede i brug. Vælg venligst en anden email.");
            model.addAttribute("user", user);
            return "register-user";
        }

        System.out.println("Bruger oprettet - redirecter...");
        return "redirect:/wishlist";
    }
}
