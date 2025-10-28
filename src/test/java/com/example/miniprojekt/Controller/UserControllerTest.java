package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUserViewLoads() throws Exception {
        mockMvc.perform(get("/wishitem/registeruser"))
                .andExpect(status().isOk())
                .andExpect(view().name("register-user"))
                .andExpect(model().attributeExists("user"));

        // ingen verify her, fordi controlleren ikke kalder UserService
    }

    @Test
    void testCreateUserCallsService() throws Exception {
        mockMvc.perform(get("/wishitem/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register-user"));

        // her kaldes UserService, så vi kan verificere
        verify(userService, times(1))
                .createUser("Moha2200", "moha2200@stud.ek.dk", "mohaergay");
    }
}
