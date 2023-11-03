package com.example.Java_Projekt.Repositories;

import com.example.Java_Projekt.Models.Files.MatureExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatureExamResultRepository extends JpaRepository<MatureExamResult, Long> {
    @Query("SELECT mer FROM MatureExamResult mer " +
            "WHERE (:przedmiot is null OR mer.przedmiot = :przedmiot) " +
            "AND (:plec is null OR mer.plec = :plec) " +
            "AND (:poziom is null OR mer.poziom_egzaminu = :poziom) " +
            "AND (:rok is null OR mer.rok = :rok)")
    List<MatureExamResult> getMatureExamResult(
            @Param("przedmiot") String przedmiot,
            @Param("plec") String plec,
            @Param("poziom") String poziom,
            @Param("rok") Integer rok
    );
}
