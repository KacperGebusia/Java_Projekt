package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "dostepy")
public class Accesses {
    @JacksonXmlProperty(localName = "dostep")
    private List<InternetAccess> AccessesList;
}
