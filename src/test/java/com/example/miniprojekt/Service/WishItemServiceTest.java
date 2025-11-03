package com.example.miniprojekt.Service;

import com.example.miniprojekt.Model.WishItemModel;
import com.example.miniprojekt.Repository.WishItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class WishItemServiceTest {

    @Mock
    private WishItemRepository wishItemRepository;

    @InjectMocks
    private WishItemService wishItemService;

    @Test
    void findWishItemByTitle_returnsCorrectItem() {

        WishItemModel item1 = new WishItemModel();
        item1.setItemTitle("Aden");

        WishItemModel item2 = new WishItemModel();
        item2.setItemTitle("Moha");

        when(wishItemRepository.getAllItems()).thenReturn(List.of(item1, item2));

        WishItemModel result = wishItemService.findWishItemByTitle("aden");

        assertNotNull(result);
        assertEquals("Aden", result.getItemTitle());
        verify(wishItemRepository, times(1)).getAllItems();
    }

    @Test
    void findWishItemByTitle_returnsNullIfNotFound() {

        WishItemModel item1 = new WishItemModel();
        item1.setItemTitle("Moha");
        when(wishItemRepository.getAllItems()).thenReturn(List.of(item1));

        WishItemModel result = wishItemService.findWishItemByTitle("Aden");

        assertNull(result);
        verify(wishItemRepository, times(1)).getAllItems();
    }


    @Test
    void createWishItem(){
        String itemTitle = "mofremmede";
        String itemDescription = "lækker";
        double itemPrice = 88;
        String itemURL = "ghvfjcbn";

        wishItemService.createWishItem(itemTitle,itemDescription,itemPrice,itemURL);

        verify(wishItemRepository,times(1)).createWishItem(itemTitle,itemDescription,itemPrice,itemURL);

    }

    @Test
    void deleteItemTitle() {
        int itemID = 0;

        wishItemService.deleteItemByItemID(itemID);

        verify(wishItemRepository,times(1)).deleteItemByItemID(itemID);


    }

    @Test
    void saveWishItem() {
        WishItemModel wishItem = new WishItemModel();
        wishItem.setItemTitle("sko");
        wishItem.setItemDescription("nye sneakers");
        wishItem.setItemPrice(499.95);

        wishItemService.saveWishItem(wishItem);

        verify(wishItemRepository, times(1)).saveWishItem(wishItem);
    }

    @Test
    void getAllItems() {

        wishItemService.getAllItems();

        verify(wishItemRepository, times(1)).getAllItems();
    }

}

