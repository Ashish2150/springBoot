package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;



@WebMvcTest(DemoController.class)
public class DemoApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("user", "testUser")
                .param("pass", "testPass")
                .header("validToken", "testToken")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Login successful")));
    }

    // Write test case for login fail
    @Test
    public void testLoginFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("user", "testUser")
                .param("pass", "testPass")
                .header("validToken", "wrongToken")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Login failed")));
    }

    
    @Test
    public void testRegistrationSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("user", "newUser")
                .param("pass", "newPass")
                .param("mobile", "1234567890")
                .header("validToken", "testToken")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Registration successful")));
    }    

}