package com.example.Java_Projekt;

import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.UserRepository;
import com.example.Java_Projekt.Services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        Optional<User> result = userService.getUserById(userId);

        verify(userRepository, times(1)).findById(userId);

        assertTrue(result.isPresent());
        assertEquals(mockUser, result.get());
    }

    @Test
    public void testGetUserById_UserNotFound() {
        Long userId = 123L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserById(userId);
        verify(userRepository, times(1)).findById(userId);

        assertTrue(result.isEmpty());
    }
}
