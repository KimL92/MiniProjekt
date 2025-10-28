package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Service.ExternalService;
import com.example.miniprojekt.Service.WishItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExternalStoresController.class)
public class WishItemControllerTest {

    @MockBean
    private WishItemService wishItemService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteItemTitle() throws Exception {
        mockMvc.perform(post("/wishitem/delete/{itemTitle}")
                        .param("itemTitle"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wishitem"));

        verify(wishItemService).deleteItemTitle("Nike Air Max");
    }
}
