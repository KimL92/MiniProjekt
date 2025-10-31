package com.example.miniprojekt.Service;

import com.example.miniprojekt.Repository.ExternalRepository;
import com.example.miniprojekt.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExternalServiceTest {

    @Mock
    private ExternalRepository externalRepository;

    @InjectMocks
    private ExternalService externalService;

    @Test
    void createExternalStores(){
        String storeName = "ahmedKiosk";
        String storeURL = "http:kiosk";
        String storeDescription = "slikbutik";
        String storeCategory = "slik";

        externalService.createExternalStores(storeName,storeURL,storeDescription,storeCategory);

        verify(externalRepository,times(1)).createExternalStores(storeName,storeURL,storeDescription,storeCategory);


    }

    @Test
    void deleteExternalStore (){

        long storeID = 1L;

        externalService.deleteExternalStore(storeID);

        verify(externalRepository,times(1)).deleteExternalStore(storeID);
    }




}
