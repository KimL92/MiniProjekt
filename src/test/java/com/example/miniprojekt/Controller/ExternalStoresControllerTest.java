package com.example.miniprojekt.Controller;

import com.example.miniprojekt.Service.ExternalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExternalStoresController.class)
public class ExternalStoresControllerTest {

    @MockBean
    private ExternalService externalService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void deleteExternalStore() throws Exception {
        mockMvc.perform(post("/wishitem/delete/{createexternalstore}",1)
                        .param("storeID", "5"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wishitem"));

        verify(externalService).deleteExternalStore(5L);
    }






}
