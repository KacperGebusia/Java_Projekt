package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Configuration.Security.JWT.JwtUtils;
import com.example.Java_Projekt.Configuration.Security.Services.UserDetailsImpl;
import com.example.Java_Projekt.Exceptions.EmailNotFoundException;
import com.example.Java_Projekt.Models.Enums.Roles;
import com.example.Java_Projekt.Models.Requests.LoginRequest;
import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.Responses.JwtResponse;
import com.example.Java_Projekt.Models.Responses.MessageResponse;
import com.example.Java_Projekt.Models.Role;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.RoleRepository;
import com.example.Java_Projekt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;
    public MessageResponse Signup(RegisterRequest registerRequest){
        MessageResponse response = new MessageResponse();
        if (userRepository.findByUsername(registerRequest.getUserName()) != null) {
            response.setMessage("Error: Username is already taken!",400);
            return response;
        }

        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            response.setMessage("Error: Email is already in use!",400);
            return response;
        }

        User user = new User(registerRequest.getFirstName(), registerRequest.getLastName(),passwordEncoder.encode(registerRequest.getPassword()), registerRequest.getUserName(), registerRequest.getEmail(), new Date());

        Set<String> strRoles = registerRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(Roles.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if (role.equals("admin")) {
                    Role adminRole = roleRepository.findByName(Roles.ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(Roles.USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        response.setMessage("Registration successful for user " + user,201);
        return response;
    }
    public JwtResponse SignIn(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(user == null){
            throw new EmailNotFoundException("Email does not match.");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }

}
