package com.project3.revtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private ProductController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    // Negative test
    // User needs to be logged in to get product
    // "Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotReturnProductUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/products/getone/1")).andDo(print()).andExpect(status().isUnauthorized());
    }
    // Negative test
    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotReturnGetAllProductsUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/products/getall")).andDo(print()).andExpect(status().isUnauthorized());
    }
    // Negative test
    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotPostNewProductUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/products/add")).andDo(print()).andExpect(status().isUnauthorized());
    }
    // Negative test
    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotUpdateProductUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/products/update/1")).andDo(print()).andExpect(status().isUnauthorized());
    }
    // Negative test
    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotDeleteProductUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/products/delete/1")).andDo(print()).andExpect(status().isUnauthorized());
    }
//------------------------------End Negative Cases----------------------------------------------------


//------------------------------Positive cases----------------------------------------------------
    //positive test with logged in user. status 200 okay expected
    //    MockHttpServletResponse:
    //           Status = 200
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldReturnProductLoggedIn() throws Exception {
        this.mockMvc.perform(get("/api/products/getone/1")).andDo(print()).andExpect(status().isOk());
    }

    //positive test with logged in user. status 200 okay expected
    //    MockHttpServletResponse:
    //           Status = 200
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldGetAllProductsLoggedIn() throws Exception {
        this.mockMvc.perform(get("/api/products/getall")).andDo(print()).andExpect(status().isOk());
    }


    // Positive Test Working
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldPostNewProductLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products/add")
                        .content(asJsonString(new ProductPojo(1, "M464545DFDFD", "computer", BigDecimal.valueOf(249.99), "computer", "Computer", 10, "https://media.istockphoto.com/photos/newly-released-iphone-13-pro-mockup-set-with-back-and-front-angles-picture-id1356372494?k=20&m=1356372494&s=612x612&w=0&h=4IyK75PK9dd4zY-CPAF_scPK-HwsoYS2mmWJZzBwp2A=", false)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // positive test working
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldUpdateProductLoggedIn() throws Exception {
     mockMvc.perform(put("/api/products/update/{pid}",1)
                .content(asJsonString(new ProductPojo(1, "M464545DFDFD", "computer", BigDecimal.valueOf(249.99), "computer", "Computer", 10, "https://media.istockphoto.com/photos/newly-released-iphone-13-pro-mockup-set-with-back-and-front-angles-picture-id1356372494?k=20&m=1356372494&s=612x612&w=0&h=4IyK75PK9dd4zY-CPAF_scPK-HwsoYS2mmWJZzBwp2A=", false)))
            .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
}

    // positive test case delete working
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldDeleteProductLoggedIn() throws Exception {
        this.mockMvc.perform(delete("/api/products/delete/{pid}",18)).andDo(print()).andExpect(status().isOk());
    }


}
