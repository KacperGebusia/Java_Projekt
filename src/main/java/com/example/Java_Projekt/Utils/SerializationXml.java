package com.example.Java_Projekt.Utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SerializationXml {
    public static void SerializeToXml(String data){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            File xmlOutput = new File("Assets\\Files\\serialized_xml.xml");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
