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
public class TestControllerTest {

    @Autowired
    private TestController testController;


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void contextLoads() throws Exception {
        assertThat(testController).isNotNull();
    }

    // -------------------------------------------- Positve Tests -------------------------------------------

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void allAccessAuthorizedLoggedInTest() throws Exception{
        this.mockMvc.perform(get("/api/test/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void userAccessAsAdminAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/test/user")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER", username = "user")
    public void userAccessAsUserAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/test/user")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE", username = "employee")
    public void userAccessAsEmployeeAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/test/user")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "MODERATOR", username = "moderator")
    public void moderatorAccessAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/test/mod")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void adminAccessAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/api/test/admin")).andDo(print()).andExpect(status().isOk());
    }



// ------------------------------------------------- Negative Tests ----------------------------------------

    @Test
    public void allAccessUnAuthorizedLoggedInTest() throws  Exception {
        this.mockMvc.perform(get("/all")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void userAccessUnAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void moderatorAccessUnAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/mod")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void adminAccessUnAuthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/admin")).andDo(print()).andExpect(status().isUnauthorized());
    }

}
