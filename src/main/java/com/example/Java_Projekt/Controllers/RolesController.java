package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.Role;
import com.example.Java_Projekt.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Roles")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class RolesController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public List<Role> GetRoles(){
        return roleService.GetRoles();
    }
    @PostMapping
    public void SetUserRole(String roleName, Long userId){
        roleService.SetUserRole(roleName, userId);
    }
}
