package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@JacksonXmlRootElement(localName = "wyniki")
public class Results{
    @JacksonXmlProperty(localName = "wynik")
    private List<MatureExamResult> ResultsList;

    public List<MatureExamResult> getResultsList() {
        return ResultsList;
    }

    public void setResultsList(List<MatureExamResult> resultsList) {
        ResultsList = resultsList;
    }
}
