package com.project3.revtech.controller;

import com.project3.revtech.service.CartItemProductServiceImpl;
import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.joinedpojo.CartAndItemsPojo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
public class CartItemProductControllerTest {

    @Autowired
    private CartItemProductController controller;

    @Autowired
    private MockMvc mockMvc;

    //------------------------------------------------ Positive Test ---------------------------------------

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void getCartAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/cart-and-items/cart/{bid}/get", 1)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void getCartByUserAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/cart-and-items/user/{bid}/get", 1)).andDo(print()).andExpect(status().isOk());
    }



    //------------------------------------------------ Negative Test -------------------------------------------

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getCartUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/cart/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void getCartByUserUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/user/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
