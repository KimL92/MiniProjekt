package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishitem")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    // test for at se om det virker
//    @GetMapping("/register")
//    public String createUser() {
//        String userName = "Moha2200";
//        String email = "moha2200@stud.ek.dk";
//        String userPassword = "mohaergay";
//        userService.createUser(userName, email, userPassword);
//
//        return "register-user";
//
//    }

    // rigtige metode
    @GetMapping("/registeruser")
    public String createUser(Model model) {
        model.addAttribute("user", new UserModel());

        return "register-user";
    }

}

