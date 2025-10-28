package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.UserRepository;
import com.example.miniprojekt.Repository.WishItemRepository;
import com.example.miniprojekt.Repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WishItemServiceTest {

    @Mock
    private WishItemRepository wishItemRepository;

    @InjectMocks
    private WishItemService wishItemService;


@Test
    void findWishItemByTitle(){
    String itemTitle = "aden";

    wishItemService.findWishItemByTitle(itemTitle);

    verify(wishItemRepository,times(1)).findWishItemByTitle(itemTitle);


}
}
