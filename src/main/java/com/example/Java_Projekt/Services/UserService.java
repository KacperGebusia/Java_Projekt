package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.Requests.UserDTO;
import com.example.Java_Projekt.Models.Responses.MessageResponse;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> fetchUsersList() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public MessageResponse EditUser(UserDTO request, Long id) {
        MessageResponse response = new MessageResponse();
        Optional<User> existingUser = userRepository.findById(id);
        if(!existingUser.isPresent()){
            response.setMessage("Nie znaleziono użytkownika z takim ID", 400);
        }
        User user = existingUser.get();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        response.setMessage("Edycja użytkownika zakończona pomyślnie.",200);
        return response;
    }
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
