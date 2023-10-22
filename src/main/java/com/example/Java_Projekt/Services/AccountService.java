package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Exceptions.PasswordNotConfirmedException;
import com.example.Java_Projekt.Exceptions.UsernameAlreadyExistsException;
import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class AccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AccountService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User RegisterUser(@NotNull RegisterRequest request){
        if(userRepository.findByUserName(request.getUserName()) != null){
            throw new UsernameAlreadyExistsException();
        }
        if(!Objects.equals(request.getConfirmPassword(), request.getPassword())){
            throw new PasswordNotConfirmedException();
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(request.getFirstName(), request.getLastName(),encodedPassword, request.getUserName(), request.getEmail(), new Date());
        userRepository.save(user);
        return user;
    }
}
