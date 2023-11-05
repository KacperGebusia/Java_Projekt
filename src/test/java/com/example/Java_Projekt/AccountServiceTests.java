package com.example.Java_Projekt;

import com.example.Java_Projekt.Configuration.Security.JWT.JwtUtils;
import com.example.Java_Projekt.Configuration.Security.Services.UserDetailsImpl;
import com.example.Java_Projekt.Exceptions.EmailNotFoundException;
import com.example.Java_Projekt.Models.Requests.LoginRequest;
import com.example.Java_Projekt.Models.Responses.JwtResponse;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.UserRepository;
import com.example.Java_Projekt.Services.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTests {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private UserDetailsService userDetailsService;
    @InjectMocks
    private AccountService accountService;
    @Test
    public void testSignIn_Success() {
        LoginRequest loginRequest = new LoginRequest("email@example.com", "password");

        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUsername("username");
        mockUser.setEmail("email@example.com");
        mockUser.setPassword(passwordEncoder.encode("password"));

        UserDetails userDetails = UserDetailsImpl.build(mockUser);

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(mockUser);

        Authentication mockAuthentication = new UsernamePasswordAuthenticationToken(userDetails, "password");
        when(authenticationManager.authenticate(any())).thenReturn(mockAuthentication);
        when(jwtUtils.generateJwtToken(mockAuthentication)).thenReturn("jwtToken");

        JwtResponse result = accountService.SignIn(loginRequest);

        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals("jwtToken", result.getAccessToken());
        assertEquals(1L, result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("email@example.com", result.getEmail());
    }

    @Test
    public void testSignIn_UserNotFound() {
        LoginRequest loginRequest = new LoginRequest("nonexistent@example.com", "password");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(null);

        assertThrows(EmailNotFoundException.class, () -> accountService.SignIn(loginRequest));
    }

    @Test
    public void testSignIn_AuthenticationFailure() {
        LoginRequest loginRequest = new LoginRequest("email@example.com", "incorrectPassword");

        User mockUser = new User();
        mockUser.setEmail("email@example.com");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(mockUser);

        when(authenticationManager.authenticate(any())).thenThrow(new BadCredentialsException("Invalid password"));

        assertThrows(BadCredentialsException.class, () -> accountService.SignIn(loginRequest));
    }
}
