package com.example.Java_Projekt.Mappers;

import com.example.Java_Projekt.Models.Files.MatureExamResult;
import com.example.Java_Projekt.Models.Requests.ExamResultsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatureExamMapper {
    MatureExamResult dtoToEntity(ExamResultsDTO source);
    ExamResultsDTO entityToDto(MatureExamResult destination);
}
