package com.example.Java_Projekt.Repositories;

import com.example.Java_Projekt.Models.Enums.Roles;
import com.example.Java_Projekt.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}