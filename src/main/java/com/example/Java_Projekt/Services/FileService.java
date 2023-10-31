package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Models.Files.Accesses;
import com.example.Java_Projekt.Models.Files.InternetAccess;
import com.example.Java_Projekt.Models.Files.MatureExamResult;
import com.example.Java_Projekt.Models.Files.Results;
import com.example.Java_Projekt.Repositories.InternetAccessRepository;
import com.example.Java_Projekt.Repositories.MatureExamResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private InternetAccessRepository internetAccessRepository;
    @Autowired
    private MatureExamResultRepository matureExamResultRepository;

    @Transactional
    public List<InternetAccess> importAccessXml(MultipartFile file) throws Exception {
        // Implement XML import logic for InternetAccess using JAXB
        JAXBContext jaxbContext = JAXBContext.newInstance(Accesses.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String xmlContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        Accesses accesses = (Accesses) unmarshaller.unmarshal(new StringReader(xmlContent));
        List<InternetAccess> internetAccesses = accesses.getAccessesList();
        internetAccessRepository.saveAll(internetAccesses);
        return internetAccesses;
    }

    @Transactional
    public List<MatureExamResult> importExamXml(MultipartFile file) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Results.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String xmlContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        Results results = (Results) unmarshaller.unmarshal(new StringReader(xmlContent));
        List<MatureExamResult> examResults = results.getResultsList();
        matureExamResultRepository.saveAll(examResults);
        return examResults;
    }
    public Accesses importInternetAccess(MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file.getInputStream(),Accesses.class);
    }
}
