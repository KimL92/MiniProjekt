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
    public String createUserPost(@ModelAttribute UserModel user) {
        userService.createUser(user.getUserName(), user.getEmail(), user.getUserPassword());
        return "redirect:/wishlist"; // eller en anden side
    }
}
