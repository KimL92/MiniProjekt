package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService;


    @Test
    void createWishlist(){
        String wishlistName = "allans 18 års";
        String wishlistDescription = "kk";

        wishlistService.createWishlist(wishlistName, wishlistDescription);

        verify(wishlistRepository,times(1)).createWishlist(wishlistName, wishlistDescription);
    }


}
