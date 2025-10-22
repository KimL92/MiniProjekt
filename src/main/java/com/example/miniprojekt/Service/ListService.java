package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.ListRepository;

public class ListService {
    public void deleteItemTitle(String itemTitle) {
        ListRepository.deleteItemTitle(itemTitle);
    }

}
