package com.example.Java_Projekt.Models;

import com.example.Java_Projekt.Models.Enums.Roles;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    public Role() {
    }

    public Role(Long id, Roles name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Enumerated(EnumType.STRING)
    public Roles name;

    public Role(Roles name) {
        this.name = name;
    }
}
