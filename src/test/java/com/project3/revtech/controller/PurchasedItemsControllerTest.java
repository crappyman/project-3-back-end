package com.project3.revtech.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchasedItemsControllerTest {

    @Autowired
    private PurchasedItemsController purchasedItemsController;

    @Autowired
    private MockMvc mockMvc;



    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void addManyItemsAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/purchased-items/transaction/{bid}/get", 1)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void getItemsByUserIdAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/purchased-items/user/{bid}/get", 1)).andDo(print()).andExpect(status().isOk());
    }


    //------------------------------------------------ Negative Test -----------------------------------------------
    @Test
    public void contextLoads() throws Exception {
        assertThat(purchasedItemsController).isNotNull();
    }


    @Test
    public void addManyItemsUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/many/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void getItemsByTransactionIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/transaction/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void getItemsByUserIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/user/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
