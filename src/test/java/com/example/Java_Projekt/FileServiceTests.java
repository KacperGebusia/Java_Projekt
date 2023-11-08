package com.example.Java_Projekt;

import com.example.Java_Projekt.Exceptions.ObjectsNotFoundInFile;
import com.example.Java_Projekt.Mappers.MatureExamMapper;
import com.example.Java_Projekt.Models.Files.InternetAccess;
import com.example.Java_Projekt.Models.Files.MatureExamResult;
import com.example.Java_Projekt.Repositories.AccessTypeRepository;
import com.example.Java_Projekt.Repositories.InternetAccessRepository;
import com.example.Java_Projekt.Repositories.MatureExamResultRepository;
import com.example.Java_Projekt.Services.FileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class FileServiceTests {

    @Mock
    private InternetAccessRepository internetAccessRepository;
    @Mock
    private AccessTypeRepository accessTypeRepository;
    @Mock
    private MatureExamResultRepository matureExamResultRepository;
    @Mock
    private MatureExamMapper mapper;

    private FileService fileService;


    @BeforeEach
    void setup(){
        internetAccessRepository = Mockito.mock(InternetAccessRepository.class);
        accessTypeRepository = Mockito.mock(AccessTypeRepository.class);
        matureExamResultRepository = Mockito.mock(MatureExamResultRepository.class);
        mapper = Mockito.mock(MatureExamMapper.class);
        fileService = new FileService(matureExamResultRepository, internetAccessRepository, accessTypeRepository, mapper);
    }
    @Test
    public void testImportInternetAccess() throws IOException, ObjectsNotFoundInFile {
        MultipartFile file = createSampleMultipartFileInternetAccess();

        List<InternetAccess> entities = createSampleEntities();

        when(internetAccessRepository.saveAll(entities)).thenReturn(entities);

        List<InternetAccess> result = fileService.importInternetAccess(file);

        assertNotNull(result);
        assertEquals(entities.size(), result.size());
    }
    @Test
    public void testImportMatureExamResults_WhenEntitiesEmpty() throws IOException, ObjectsNotFoundInFile {
        MultipartFile file = createSampleMultipartFileMatureExamResults();
        List<MatureExamResult> entities = createEmptyMatureExamResultEntities();
        ObjectMapper objectMapper = new ObjectMapper();

        //when(objectMapper.readValue(file.getInputStream(), new TypeReference<List<MatureExamResult>>() {})).thenReturn(entities);

        try {
            List<MatureExamResult> result = fileService.importMatureExamResults(file);
        } catch (ObjectsNotFoundInFile e) {
            assertEquals("No objects found in the file.", e.getMessage());
            verify(matureExamResultRepository, never()).saveAll(entities);
        }
    }

    private List<MatureExamResult> createEmptyMatureExamResultEntities() {
        return Collections.emptyList();
    }

    @Test
    public void testImportInternetAccess_WhenRepositoryFails() throws IOException {
        MultipartFile file = createSampleMultipartFileInternetAccess();

        List<InternetAccess> entities = createSampleEntities();

        when(internetAccessRepository.saveAll(entities)).thenThrow(new RuntimeException("Saving entities to db failed."));

        try {
            List<InternetAccess> result = fileService.importInternetAccess(file);
        } catch (Exception e) {
            verify(internetAccessRepository).saveAll(entities);
        }
    }
    private MultipartFile createSampleMultipartFileInternetAccess() {
        String internetAccessJson = """
                  [
                    {
                      "r2011": 60,
                      "r2012": 60,
                      "r2013": 60,
                      "r2014": 60,
                      "r2015": 60,
                      "r2016": 60,
                      "r2017": 60,
                      "r2018": 60,
                      "r2019": 60,
                      "r2020": 60,
                      "r2021": 60,
                      "r2022": 60,
                      "type": "1"
                    },
                    {
                      "r2011": 50,
                      "r2012": 50,
                      "r2013": 50,
                      "r2014": 50,
                      "r2015": 50,
                      "r2016": 50,
                      "r2017": 50,
                      "r2018": 50,
                      "r2019": 50,
                      "r2020": 50,
                      "r2021": 50,
                      "r2022": 50,
                      "type": "2"
                    }
                ]""";
        return new MockMultipartFile("file", "internet-access.json", "text/plain", internetAccessJson.getBytes());
    }
    private MultipartFile createSampleMultipartFileMatureExamResults() {
        String matureExamResultsJson = """
                  []""";
        return new MockMultipartFile("file", "mature-exam-results.json", "text/plain", matureExamResultsJson.getBytes());
    }

    private List<InternetAccess> createSampleEntities() {
        List<InternetAccess> entities = new ArrayList<>();
        InternetAccess entity1 = new InternetAccess(1L,"1",60,60,60,60,60,60,60,60,60,60,60,60);
        InternetAccess entity2 = new InternetAccess(1L,"2",50,50,50,50,50,50,50,50,50,50,50,50);
        entities.add(entity1);
        entities.add(entity2);

        return entities;
    }
}
