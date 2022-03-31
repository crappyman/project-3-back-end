package com.project3.revtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project3.revtech.dao.CartItemRepository;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartItemPojo;
import com.project3.revtech.service.CartItemServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartItemControllerTest {

    @Autowired
    private CartItemController cartItemController;

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Missing two methods here for Post and Put
    @Test
    public void addItemPositiveTest() throws Exception {
        mockMvc.perform(post("/api/cart-items/post")
                .content(asJsonString(new CartItemPojo(1, 1, 1, 99)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void updateItemPositiveTest() throws Exception {
        mockMvc.perform(put("/api/cart-items/put")
                .content(asJsonString(new CartItemPojo(1, 1, 1, 50)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }



    @Test
    @WithMockUser
    public void removeItemAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(delete("/api/cart-items/{bid}/delete", 1)).andDo(print()).andExpect(status().isOk());
    }


    //------------------------------------------- Negative Test --------------------------------------------------------
    @Test
    public void contextLoads() throws Exception {
        assertThat(cartItemController).isNotNull();
    }

    @Test
    public void addItemUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void updateItemUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/put")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void removeItemUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/1/delete")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
