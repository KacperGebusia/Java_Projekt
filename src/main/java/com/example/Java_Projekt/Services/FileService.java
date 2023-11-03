package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Mappers.MatureExamMapper;
import com.example.Java_Projekt.Models.Files.*;
import com.example.Java_Projekt.Models.Requests.ExamResultsDTO;
import com.example.Java_Projekt.Repositories.AccessTypeRepository;
import com.example.Java_Projekt.Repositories.InternetAccessRepository;
import com.example.Java_Projekt.Repositories.MatureExamResultRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private MatureExamResultRepository matureExamResultRepository;
    @Autowired
    private InternetAccessRepository internetAccessRepository;
    @Autowired
    private AccessTypeRepository accessTypeRepository;
    @Autowired
    private MatureExamMapper mapper;

    public List<InternetAccess> importInternetAccess(MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<InternetAccess>entities = mapper.readValue(file.getInputStream(),new TypeReference<List<InternetAccess>>() {});
        internetAccessRepository.saveAll(entities);
        return entities;
    }
    public List<MatureExamResult> importMatureExamResults(MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<MatureExamResult>entities = mapper.readValue(file.getInputStream(),new TypeReference<List<MatureExamResult>>() {});
        matureExamResultRepository.saveAll(entities);
        return entities;
    }
    public List<MatureExamResult> getMatureExamResults(@Nullable String plec, @Nullable String przedmiot, @Nullable String poziom, @Nullable Integer rok){

        return matureExamResultRepository.findAll();
    }
    public List<MatureExamResult> getMatureExamResults() {
        return matureExamResultRepository.findAll(); // Retrieve all results
    }

    public List<MatureExamResult> getMatureExamResults(String przedmiot) {
        return matureExamResultRepository.getMatureExamResult(przedmiot, null, null, null);
    }

    public List<MatureExamResult> getMatureExamResults(String przedmiot, String plec) {
        return matureExamResultRepository.getMatureExamResult(przedmiot, plec, null, null);
    }

    public List<MatureExamResult> getMatureExamResults(String przedmiot, String plec, String poziom) {
        return matureExamResultRepository.getMatureExamResult(przedmiot, plec, poziom, null);
    }
    public List<AccessType> getAccessTypes(){
        return accessTypeRepository.findAll();
    }
    public List<InternetAccess> getInternetAccess(){
        return internetAccessRepository.findAll();
    }
    public void deleteData(){
        internetAccessRepository.deleteAll();
        matureExamResultRepository.deleteAll();
    }
    public void addMatureExamResult(ExamResultsDTO examResult){
        MatureExamResult result = mapper.dtoToEntity(examResult);
        result.setFlaga("");
        result.setTyp_informacji_z_jednostka_miary("relacja [%]");
        result.setNazwa_zmiennej("Średnie wyniki egzaminu maturalnego");
        matureExamResultRepository.save(result);
    }
}
