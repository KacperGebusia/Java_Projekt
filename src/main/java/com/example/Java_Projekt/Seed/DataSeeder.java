package com.example.Java_Projekt.Seed;

import com.example.Java_Projekt.Configuration.Security.Services.UserDetailsImpl;
import com.example.Java_Projekt.Models.Enums.Roles;
import com.example.Java_Projekt.Models.Files.AccessType;
import com.example.Java_Projekt.Models.Role;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.AccessTypeRepository;
import com.example.Java_Projekt.Repositories.RoleRepository;
import com.example.Java_Projekt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccessTypeRepository accessTypeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        CreateRoles();
        CreateAccessTypes();
        CreateDefaultUser();
    }

    private void CreateDefaultUser() {
        Set<Role> roles = new HashSet<>();
        if(userRepository.findByEmail("jankowalski@gmail.com") == null){
            User user = new User("Jan","Kowalski",passwordEncoder.encode("Haslo123!"),"Janek","jankowalski@gmail.com",new Date());
            Role adminRole = roleRepository.findByName(Roles.ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
            user.setRoles(roles);
            UserDetailsImpl.build(user);
            userRepository.save(user);
        }
    }

    private void CreateAccessTypes() {
        List<AccessType> accessTypes = new ArrayList<>();
        if(accessTypeRepository.findAll().size() == 0){
            accessTypes.add(new AccessType(1,"I_ILT12","Ostatni raz korzystało z internetu w ostatnich 12 miesiącach"));
            accessTypes.add(new AccessType(2,"I_IUX","Nigdy nie korzystało"));
            accessTypes.add(new AccessType(3,"I_IU3","Ostatni raz korzystało z internetu w ostatnich 3 miesiącach"));
            accessTypes.add(new AccessType(4,"I_IUEVR","Kiedykolwiek korzystało"));
            accessTypeRepository.saveAll(accessTypes);
        }
    }

    private void CreateRoles(){
        List<Role> roles = new ArrayList<>();
        if(roleRepository.findAll().size() == 0){
            roles.add(new Role(Roles.USER));
            roles.add(new Role(Roles.ADMIN));
            roleRepository.saveAll(roles);
        }
    }
}
