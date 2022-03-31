package com.project3.revtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.ProductPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountControllerTest {

    @Autowired
    private DiscountController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotReturnGetAllDiscountsUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/all/discounts")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotPostNewDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/add/discounts")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotDeleteDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/remove/discounts/1")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotUpdateDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/update/discounts")).andDo(print()).andExpect(status().isUnauthorized());
    }

    // failing Caused by: java.lang.StackOverflowError
    //org.springframework.web.util.NestedServletException: Handler dispatch failed; nested exception is java.lang.StackOverflowError
    // Bug Detected, put in bug report, confirmed with postman test
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldReturnGetAllDiscountsLoggedIn() throws Exception {
        this.mockMvc.perform(get("/discount/all/discounts")).andDo(print()).andExpect(status().isOk());
    }

    // Positive delete test working
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldDeleteDiscountLoggedIn() throws Exception {
        this.mockMvc.perform(delete("/discount/remove/discounts/{discId}", 4)).andDo(print()).andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Positive update discount
    // working
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldUpdateDiscountLoggedIn() throws Exception {
        mockMvc.perform(put("/discount/update/discounts")
                        .content(asJsonString(new DiscountPojo(4 , 6, "always running", BigDecimal.valueOf(9.99))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());


    }

    // positive test case for post new discount
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldPostNewDiscountLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/discount/add/discounts")
                        .content(asJsonString(new DiscountPojo(4 , 6, "always running", BigDecimal.valueOf(9.99))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());


    }

}
