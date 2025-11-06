package com.example.miniprojekt.Controller;

// Importerer nødvendige klasser fra Spring Framework og egne pakker
import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Gør denne klasse til en Spring MVC Controller
@Controller
// Angiver, at alle endpoints i denne controller starter med "/login"
@RequestMapping("/login")
public class UserController {

    // Reference til UserService, som håndterer logikken bag brugere
    private final UserService userService;

    // Constructor der modtager UserService via dependency injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Viser login-siden når man går til /login
    @GetMapping()
    public String getLogin() {
        return "login"; // Returnerer navnet på HTML-siden (login.html)
    }

    // Viser siden hvor man kan oprette en ny bruger
    @GetMapping("/create-user")
    public String createUser(Model model) {
        model.addAttribute("user", new UserModel()); // Tilføjer tom bruger til modellen
        return "register-user"; // Viser register-user.html
    }

    // Modtager data fra formularen, når man opretter bruger (POST)
    @PostMapping(("/create-user"))
    public String createUserPost(@ModelAttribute UserModel user, Model model) {
        System.out.println("Forsøger at oprette bruger: " + user.getEmail());

        // Forsøger at oprette brugeren via UserService
        boolean success = userService.createUser(user.getUserName(), user.getEmail(), user.getUserPassword());

        // Hvis email allerede findes, vis fejlbesked
        if (!success) {
            System.out.println("Oprettelse fejlede - viser error");
            model.addAttribute("error", "Denne email er allerede i brug. Vælg venligst en anden email.");
            model.addAttribute("user", user);
            return "register-user"; // Viser registreringssiden igen
        }

        // Hvis alt gik godt, send brugeren videre til wishlist
        System.out.println("Bruger oprettet - redirecter...");
        return "redirect:/wishlist";
    }

    // Redirecter til registreringssiden (bruges måske ikke)
    @GetMapping("/gotocreateuser")
    public String createUserSite(Model model) {
        model.addAttribute("user", new UserModel());
        return "redirect:/register-user";
    }

    // Validerer loginoplysninger fra formularen
    @PostMapping("/validate-login")
    public String validateLogin(@RequestParam("username") String username,
                                @RequestParam("password") String userPassword,
                                Model model) {
        Integer id = null;

        // Kalder UserService for at tjekke login
        id = userService.validateLogin(username, userPassword);

        // Hvis login er gyldigt, send brugeren til deres wishlist
        if (id != null) {
            return "redirect:/wishlist/show-wishlist?id=" + id;
        } else {
            // Ellers vis fejlbesked og gå tilbage til login
            model.addAttribute("error", "Brugernavn eller kode er forkert. Prøv igen!");
            return "redirect:/login";
        }
    }
}
