package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WishListController.class)
public class WishListControllerTest {

    @MockBean
    private WishListService wishListService;

    @Autowired
    private MockMvc mockMvc;

    // Test af /createwishlist (uden verify, da service ikke kaldes)
    @Test
    void testCreateWishListViewLoads() throws Exception {
        mockMvc.perform(get("/wishitem/createwishlist"))
                .andExpect(status().isOk())
                .andExpect(view().name("wishlists"))
                .andExpect(model().attributeExists("wishlistitem"));
    }

    // Test af /createwishlistt (med verify, fordi service kaldes)
    @Test
    void testCreateWishListtCallsService() throws Exception {
        mockMvc.perform(get("/wishitem/createwishlistt"))
                .andExpect(status().isOk())
                .andExpect(view().name("createItem"));

        // verify at servicen blev kaldt med det forventede navn
        verify(wishListService, times(1)).createWishList("Alan til salg");
    }
}
