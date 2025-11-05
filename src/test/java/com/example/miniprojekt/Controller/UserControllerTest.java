package com.example.miniprojekt.Controller;

import ch.qos.logback.core.model.Model;
import com.example.miniprojekt.Model.UserModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static javax.management.Query.eq;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.junit.jupiter.api.Assertions.*;
class UserControllerTest {

    @Mock
    private Model model;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        // Act
        String seName = userController.createUser(model);

        // Assert
        verify(model).addAttribute(eq("user"), any(UserModel.class));
        assertEquals("register-user", seName);
    }

    @Test
    void createUserPost() {
    }
}