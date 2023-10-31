package com.example.Java_Projekt.Repositories;

import com.example.Java_Projekt.Models.Files.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTypeRepository extends JpaRepository<AccessType, Long> {
}
