package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.WishItemRepository;

public class ListService {
    public void deleteItemTitle(String itemTitle) {
        WishItemRepository.deleteItemTitle(itemTitle);
    }

}
