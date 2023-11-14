package com.example.Java_Projekt.Repositories;

import com.example.Java_Projekt.Models.Files.MatureExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatureExamResultRepository extends JpaRepository<MatureExamResult, Long> {
}
