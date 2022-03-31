package com.project3.revtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartPojo;
import com.project3.revtech.service.CartService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private CartController cartController;

    @Autowired
    private MockMvc mockMvc;

    // "Full authentication is required to access this resource","status":401
    @Test
    public void contextLoads() throws Exception {
        assertThat(cartController).isNotNull();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addCartPositiveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cart/post")
                .content(asJsonString(new CartPojo(1, 1, 1, true, true)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void updateCartPositiveTest() throws Exception {
        mockMvc.perform(put("/api/cart/put")
                .content(asJsonString(new CartPojo(1, 1, 121, true, true)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }


// ------------------------------------------------ Negative Test -----------------------------------------

    // "Full authentication is required to access this resource","status":401
    @Test
    public void addCartUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    // "Full authentication is required to access this resource","status":401
    @Test
    public void updateCartUnauthorizedLoggedInTest() throws  Exception {
        this.mockMvc.perform(get("/put")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
