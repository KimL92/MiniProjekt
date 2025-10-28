package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.UserModel;
import com.example.miniprojekt.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService ;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void createUser() throws Exception {

        mockMvc.perform(get("/wishitem/registeruser"))
                .andExpect(status().isOk())
                .andExpect(view().name("register-user"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", instanceOf(UserModel.class)));

    }

    verify/userService, times(1))
            .createUser("Moha2200", "moha2200@stud.ek.dk", "mohaergay" );
}
