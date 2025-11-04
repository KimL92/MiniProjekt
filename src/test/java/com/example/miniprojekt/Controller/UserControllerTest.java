package com.example.miniprojekt.Controller;

import ch.qos.logback.core.model.Model;
import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wishitem")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registeruser")
    public String showRegisterUserForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "register-user";
    }

    @GetMapping("/register")
    public String createUser() {
        userService.createUser("Moha2200", "moha2200@stud.ek.dk", "mohafremmede");
        return "register-user";
    }
}
