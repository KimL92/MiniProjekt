package com.example.miniprojekt.Service;


import com.example.miniprojekt.Repository.ExternalRepository;
import com.example.miniprojekt.Repository.WishItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    @Autowired
    private ExternalRepository externalRepository;

    public void ExternalRepository (ExternalRepository externalRepository){
        this.externalRepository = externalRepository;
    }

    public void createExternalStores(String storeName, String storeURL, String storeDescription, String storeCategory){
        externalRepository.createExternalStores(storeName, storeURL, storeDescription, storeCategory);
    }

    public void deleteExternalStore(long storeID) {
            externalRepository.deleteExternalStore(storeID);

    }
}
