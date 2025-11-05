package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.WishlistModel;
import com.example.miniprojekt.Service.WishlistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    private WishlistController wishlistController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        wishlistController = new WishlistController(wishlistService);

        // Konfigurer ViewResolver for at undgå circular view path fejl
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(wishlistController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    void showAllWishlists() throws Exception {
        // Arrange - Forbered test data
        List<WishlistModel> wishlists = new ArrayList<>();
        wishlists.add(new WishlistModel(33, "neymar", "bold"));
        wishlists.add(new WishlistModel(10, "messi", "barcelona"));

        when(wishlistService.getAllWishlists()).thenReturn(wishlists);

        // Act & Assert - Udfør request og verificer resultat
        mockMvc.perform(MockMvcRequestBuilders.get("/wishlist"))
                .andExpect(status().isOk())
                .andExpect(view().name("wishlist"))
                .andExpect(model().attributeExists("wishlists"))
                .andExpect(model().attribute("wishlists", wishlists));

        // Verify - Tjek at service metoden blev kaldt
        verify(wishlistService, times(1)).getAllWishlists();
    }

    @Test
    void showCreateForm() {


    }

    @Test
    void createWishList() {
    }

    @Test
    void saveWishList() {
    }

    @Test
    void deleteWishlist() {
    }

    @Test
    void deleteWishlistItem() {
    }
}