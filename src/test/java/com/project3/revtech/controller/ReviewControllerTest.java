package com.project3.revtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.ReviewPojo;
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
import java.security.Timestamp;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTest {

    @Autowired
    private ReviewsController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    // negative tests
    //"error":"Unauthorized","message":"Full authentication is required to access this resource","status":401
    @Test
    public void shouldReturnAllReviewsUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/all/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }
    // negative tests
    //"error":"Unauthorized","message":"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotPostReviewsUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //    MockHttpServletResponse:
    //           Status = 200
    // Positive Test
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldReturnAllReviews() throws Exception {
        this.mockMvc.perform(get("/api/reviews/all/1/get")).andDo(print()).andExpect(status().isOk());
    }

    // 200 ok positive test for posting new review
    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void shouldPostReviewsLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews/post")
                        .content(asJsonString(new ReviewPojo(1, 1, 1, null, "test", 5, "test" )))
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

}
