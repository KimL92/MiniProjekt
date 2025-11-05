package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getLogin() {
        return "login";
    }

    // rigtige metode
    @GetMapping("/create-user")
    public String createUser(Model model) {
        model.addAttribute("user", new UserModel());
        return "register-user";
    }

    @PostMapping(("/create-user"))
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

    @GetMapping("/gotocreateuser")
    public String createUserSite(Model model) {
        model.addAttribute("user", new UserModel());
        return "redirect:/register-user";
    }

    @PostMapping("/validate-login")
    public String validateLogin(@RequestParam("username") String username, @RequestParam("password") String userPassword, Model model) {
        Integer id = null;
        id = userService.validateLogin(username, userPassword);

        if (id != null) {
            return "redirect:/wishlist/show-wishlist?id=" + id;
        } else {
            model.addAttribute("error", "Brugernavn eller kode er forkert. Prøv igen!");
            return "redirect:/login";
        }
    }
}
