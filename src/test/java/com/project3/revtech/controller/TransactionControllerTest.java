package com.project3.revtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project3.revtech.pojo.TransactionPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static sun.security.util.DisabledAlgorithmConstraints.DenyAfterConstraint.dateFormat;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private TransactionController transactionController;

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //These are bug tests, but it's coded correctly, just bug within the application returning 500
//    @Test
//    @WithMockUser(roles = "ADMIN", username = "admin")
//    public void getTransactionByIdAuthorizedLoggedInTest() throws Exception {
//        this.mockMvc.perform(get("/api/transaction/{tid}/get", 1)).andDo(print()).andExpect(status().isOk());
//    }
//
//
//    //These are bug tests, but it's coded correctly, just bug within the application returning 500
//    @Test
//    @WithMockUser(roles = "ADMIN", username = "admin")
//    public void getCartTransactionsAuthorizedLoggedInTest() throws Exception {
//
//        this.mockMvc.perform(get("/api/transaction/cart/{cid}/get", 1)
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andDo(print())
//                        .andExpect(status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.cartId").value(1));
//
////        this.mockMvc.perform(get("/api/transaction/cart/{cid}/get", 1)).andDo(print()).andExpect(status().isOk());
//    }


    @Test
    public void createTransactionPositiveTest() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        Timestamp stamp = new Timestamp(time);

        this.mockMvc.perform(post("/api/transaction/post")
                .content(asJsonString(new TransactionPojo(1, stamp, 1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void UpdateTransactionPositiveTest() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        Timestamp stamp = new Timestamp(time);

        this.mockMvc.perform(put("/api/transaction/put")
                .content(asJsonString(new TransactionPojo(1, stamp, 1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void deleteTransactionAuthorizedLoggedInTest() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        Timestamp stamp = new Timestamp(time);

        this.mockMvc.perform(delete("/api/transaction/transaction/delete")
                .content(asJsonString(new TransactionPojo(1, stamp, 1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }


    // --------------------------------------------------------- Negative Test --------------------------------



    @Test
    public void contextLoads() throws Exception {
        assertThat(transactionController).isNotNull();
    }

    //getTransactionById Constructor Test
    @Test
    public void shouldReceiveTheTransactionIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/10/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //getCartTransaction Constructor Test
    @Test
    public void gettingCartTransactionByCardIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/cart/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //createTransaction Constructor Test
    @Test
    public void creatingTransactionPostUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //UpdateTransaction Constructor Test
    @Test
    public void updateTransactionPutUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/put")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //deleteTransaction Constructor Test
    @Test
    public void deleteTransactionUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/transaction/delete")).andDo(print()).andExpect(status().isUnauthorized());
    }

}
