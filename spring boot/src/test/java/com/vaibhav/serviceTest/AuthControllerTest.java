package com.vaibhav.serviceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhav.config.JwtProvider;
import com.vaibhav.controller.AuthController;
import com.vaibhav.model.User;
import com.vaibhav.repository.UserRepository;
import com.vaibhav.request.LoginRequest;
import com.vaibhav.response.AuthResponse;
import com.vaibhav.service.CustomeUserServiceImplementation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private JwtProvider jwtProvider;

    @MockBean
    private CustomeUserServiceImplementation customeUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSignupSuccess() throws Exception {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setGender("Male");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtProvider.generateToken(any())).thenReturn("dummy-token");

        mockMvc.perform(post("/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.jwt").value("dummy-token"))
            .andExpect(jsonPath("$.message").value("Registration Successfull"));
    }

    @Test
    public void testSigninSuccess() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@example.com");
        loginRequest.setPassword("password");

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
            "test@example.com", "encodedPassword", new java.util.ArrayList<>());

        when(customeUserService.loadUserByUsername("test@example.com")).thenReturn(userDetails);
        when(passwordEncoder.matches("password", "encodedPassword")).thenReturn(true);
        when(jwtProvider.generateToken(any())).thenReturn("dummy-token");

        mockMvc.perform(post("/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.jwt").value("dummy-token"))
            .andExpect(jsonPath("$.message").value("Login Success"));
    }

    @Test
    public void testSignupEmailAlreadyExists() throws Exception {
        User user = new User();
        user.setEmail("duplicate@example.com");
        user.setPassword("password");
        user.setFirstName("Jane");

        when(userRepository.findByEmail("duplicate@example.com")).thenReturn(Optional.of(user));

        mockMvc.perform(post("/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isInternalServerError());
    }

    @Test
    public void testSigninInvalidPassword() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@example.com");
        loginRequest.setPassword("wrong-password");

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
            "test@example.com", "encodedPassword", new java.util.ArrayList<>());

        when(customeUserService.loadUserByUsername("test@example.com")).thenReturn(userDetails);
        when(passwordEncoder.matches("wrong-password", "encodedPassword")).thenReturn(false);

        mockMvc.perform(post("/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isUnauthorized());
    }
}
