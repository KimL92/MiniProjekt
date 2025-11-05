package com.example.miniprojekt.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Service.WishItemService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WishItemControllerTest {

    @Mock
    private WishItemService wishItemService;

    @InjectMocks
    private WishItemController wishItemController;

    @Test
    void saveWishItem_callsServiceAndRedirects() {
        // Arrange
        WishItemModel item = new WishItemModel();

        // Act
        String viewName = wishItemController.saveWishItem(item);

        // Assert
        verify(wishItemService).saveWishItem(item);
        assertEquals("redirect:/wishItem", viewName); // ret til /wishitem hvis din route er lowercase
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void showItemsForWishlist() {
    }

    @Test
    void createWishItem() {
    }

    @Test
    void deleteItemByItemID() {
    }
}