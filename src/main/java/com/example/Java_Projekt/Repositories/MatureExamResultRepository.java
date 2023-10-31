package com.example.Java_Projekt.Repositories;

import com.example.Java_Projekt.Models.Files.MatureExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatureExamResultRepository extends JpaRepository<MatureExamResult, Long> {
}
