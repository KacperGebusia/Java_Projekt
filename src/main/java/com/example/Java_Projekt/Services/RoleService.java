package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Models.Enums.Roles;
import com.example.Java_Projekt.Models.Role;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.RoleRepository;
import com.example.Java_Projekt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Role> GetRoles(){
        return roleRepository.findAll();
    }

    public void SetUserRole(String roleName, Long userId) {
        User user = userRepository.findById(userId).get();
        Role role = roleRepository.findByName(Roles.valueOf(roleName)).get();
        Set<Role> userRoles = user.getRoles();
        if(role != null){
            userRoles.add(role);
        }
        userRepository.save(user);
    }
}
