package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Exceptions.ObjectsNotFoundInFile;
import com.example.Java_Projekt.Mappers.MatureExamMapper;
import com.example.Java_Projekt.Models.Files.*;
import com.example.Java_Projekt.Models.Requests.ExamResultsDTO;
import com.example.Java_Projekt.Repositories.AccessTypeRepository;
import com.example.Java_Projekt.Repositories.InternetAccessRepository;
import com.example.Java_Projekt.Repositories.MatureExamResultRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {


    private MatureExamResultRepository matureExamResultRepository;
    private InternetAccessRepository internetAccessRepository;
    private AccessTypeRepository accessTypeRepository;
    private MatureExamMapper mapper;

    public FileService(MatureExamResultRepository matureExamResultRepository, InternetAccessRepository internetAccessRepository, AccessTypeRepository accessTypeRepository, MatureExamMapper mapper) {
        this.matureExamResultRepository = matureExamResultRepository;
        this.internetAccessRepository = internetAccessRepository;
        this.accessTypeRepository = accessTypeRepository;
        this.mapper = mapper;
    }

    public List<InternetAccess> importInternetAccess(MultipartFile file) throws IOException, ObjectsNotFoundInFile {
        ObjectMapper mapper = new ObjectMapper();
        List<InternetAccess>entities = mapper.readValue(file.getInputStream(),new TypeReference<List<InternetAccess>>() {});
        if(entities.isEmpty())
            throw new ObjectsNotFoundInFile();
        internetAccessRepository.saveAll(entities);
        return entities;
    }
    public List<MatureExamResult> importMatureExamResults(MultipartFile file) throws IOException, ObjectsNotFoundInFile {
        ObjectMapper mapper = new ObjectMapper();
        List<MatureExamResult>entities = mapper.readValue(file.getInputStream(),new TypeReference<List<MatureExamResult>>() {});
        if(entities.isEmpty())
            throw new ObjectsNotFoundInFile();
        matureExamResultRepository.saveAll(entities);
        return entities;
    }
    public List<MatureExamResult> getMatureExamResults() {
        return matureExamResultRepository.findAll(); // Retrieve all results
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
