package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Model.ExternalStores;
import com.example.miniprojekt.Service.ExternalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.times;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExternalStoresController.class)
public class ExternalStoresControllerTest {

    @MockBean
    private ExternalService externalService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void deleteExternalStore() throws Exception {
        mockMvc.perform(post("/wishitem/delete/{createexternalstore}", 1)
                        .param("storeID", "5"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wishitem"));

        verify(externalService).deleteExternalStore(5L);
    }

    @Test
    void testCreateExternalStoreViewLoads() throws Exception {
        mockMvc.perform(get("/wishitem/createexternalstore"))
                .andExpect(status().isOk())
                .andExpect(view().name("createitem"))
                .andExpect(model().attributeExists("externalstores"));

        // ❌ fjern verify her, fordi controlleren ikke kalder servicen
    }

    @Test
    void testCreateExternalStoresCallsService() throws Exception {
        mockMvc.perform(get("/wishitem/createexternalstores"))
                .andExpect(status().isOk())
                .andExpect(view().name("createstore"));

        // ✅ denne controller-metode kalder externalService, så verify er korrekt her
        verify(externalService, times(1))
                .createExternalStores("zara", "moha2200@stud.ek.dk", "test123", "flash");
    }
}
