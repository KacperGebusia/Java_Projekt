package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.Files.AccessType;
import com.example.Java_Projekt.Models.Files.InternetAccess;
import com.example.Java_Projekt.Models.Files.MatureExamResult;
import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.Responses.MessageResponse;
import com.example.Java_Projekt.Repositories.AccessTypeRepository;
import com.example.Java_Projekt.Repositories.InternetAccessRepository;
import com.example.Java_Projekt.Repositories.MatureExamResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("File")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class FileController {

    @Autowired
    private MatureExamResultRepository matureExamResultRepository;
    @Autowired
    private InternetAccessRepository internetAccessRepository;
    @Autowired
    private AccessTypeRepository accessTypeRepository;
    @GetMapping("/get-mature-exam-result")
    public List<MatureExamResult> getMatureExamResult() {
        return matureExamResultRepository.findAll();
    }

    @GetMapping("/get-internet-access")
    public List<InternetAccess> getInternetAccesses() {
        return internetAccessRepository.findAll();
    }

    @PostMapping("/add-internet-access")
    public void addInternetAccess(@RequestBody InternetAccess access) {
        internetAccessRepository.save(access);
    }

    @PostMapping("/add-mature-exam-result")
    public void addMatureExamResult(@RequestBody MatureExamResult result) {
        matureExamResultRepository.save(result);
    }

    @DeleteMapping("/delete-all-data")
    public void deleteAllData() {
        internetAccessRepository.deleteAll();
        matureExamResultRepository.deleteAll();
    }

    @GetMapping("/get-accesses-type")
    public List<AccessType> getAccessesType() {
        return accessTypeRepository.findAll();
    }
}
