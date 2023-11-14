package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.Files.AccessType;
import com.example.Java_Projekt.Models.Files.InternetAccess;
import com.example.Java_Projekt.Models.Files.MatureExamResult;
import com.example.Java_Projekt.Models.Requests.ExamResultsDTO;
import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.Responses.MessageResponse;
import com.example.Java_Projekt.Repositories.AccessTypeRepository;
import com.example.Java_Projekt.Repositories.InternetAccessRepository;
import com.example.Java_Projekt.Repositories.MatureExamResultRepository;
import com.example.Java_Projekt.Services.FileService;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("File")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class FileController {
    @Autowired
    private FileService fileService;
    @GetMapping("/get-mature-exam-result")
    public List<MatureExamResult> getMatureExamResult() {
        return fileService.getMatureExamResults();
    }
    @GetMapping("/get-internet-access")
    public List<InternetAccess> getInternetAccesses() {
        return fileService.getInternetAccess();
    }
    @PostMapping("/add-mature-exam-result")
    public void addMatureExamResult(@RequestBody ExamResultsDTO result) {
        fileService.addMatureExamResult(result);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete-all-data")
    public void deleteAllData() { fileService.deleteData(); }

    @GetMapping("/get-accesses-type")
    public List<AccessType> getAccessesType() {
        return fileService.getAccessTypes();
    }
}
