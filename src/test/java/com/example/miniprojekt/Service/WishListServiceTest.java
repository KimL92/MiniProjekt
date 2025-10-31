package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.UserRepository;
import com.example.miniprojekt.Repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {

    @Mock
    private WishListRepository wishListRepository;

    @InjectMocks
    private WishListService wishListService;


    @Test
    void createWishList(){
        String wishListName = "allans 18 års";
        String wishListDescription = "kk";

        wishListService.createWishList(wishListName, wishListDescription);

        verify(wishListRepository,times(1)).createWishList(wishListName, wishListDescription);
    }


}
