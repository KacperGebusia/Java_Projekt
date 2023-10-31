package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.Files.Accesses;
import com.example.Java_Projekt.Models.Files.InternetAccess;
import com.example.Java_Projekt.Models.Files.MatureExamResult;

import com.example.Java_Projekt.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private final FileService fileService;

    public ImportController(FileService fileService) {
        this.fileService = fileService;
    }

/*    @PostMapping("/import-mature-exam-results")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> importMatureExamResults(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Niepoprawny plik.");
        }

        String fileExtension = file.getOriginalFilename();
        if (fileExtension != null && (fileExtension.toLowerCase().endsWith(".json") || fileExtension.toLowerCase().endsWith(".xml"))) {
            try {
                // Call the appropriate service method for import
                // You should implement this service method to handle JSON or XML imports
                List<MatureExamResult> result = fileService.importMatureExamResults(file);
                return ResponseEntity.ok(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Błąd podczas importu: " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("Nieprawidłowy format pliku.");
        }
    }*/

    @PostMapping("/import-internet-accesses")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> importInternetAccess(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Niepoprawny plik.");
        }

        String fileExtension = file.getOriginalFilename();
        if (fileExtension != null && (fileExtension.toLowerCase().endsWith(".json") || fileExtension.toLowerCase().endsWith(".xml"))) {
            try {
                Accesses result = fileService.importInternetAccess(file);
                return ResponseEntity.ok(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Błąd podczas importu: " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("Nieprawidłowy format pliku.");
        }
    }
}