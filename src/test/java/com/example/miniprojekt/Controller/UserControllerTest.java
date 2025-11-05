package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private Model model;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void createUser_addsEmptyUserToModel_andReturnsRegisterUserView() {
        // Act
        String viewName = userController.createUser(model);

        // Assert
        verify(model).addAttribute(eq("user"), any(UserModel.class));
        assertEquals("register-user", viewName);
    }
}
