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
public class ProductAndDiscountControllerTest {

    @Autowired
    private ProductAndDiscountController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    // "Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotReturnGetProductAndDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //MockHttpServletResponse:
    //Status = 200
    // positive test
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldReturnGetProductAndDiscountLoggedIn() throws Exception {
        this.mockMvc.perform(get("/api/product-discount/1/get")).andDo(print()).andExpect(status().isOk());
    }
}
