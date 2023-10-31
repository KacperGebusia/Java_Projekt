package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "mature_exam_results")
public class MatureExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JacksonXmlProperty(localName = "nazwa_zmiennej")
    private String nazwa_zmiennej;
    @JacksonXmlProperty(localName = "rodzaj_egzaminu")
    private String rodzaj_egzaminu;
    @JacksonXmlProperty(localName = "poziom_egzaminu")
    private String poziom_egzaminu;
    @JacksonXmlProperty(localName = "przedmiot")
    private String przedmiot;
    @JacksonXmlProperty(localName = "plec")
    private String plec;
    @JacksonXmlProperty(localName = "typ_informacji_z_jednostka_miary")
    private String typ_informacji_z_jednostka_miary;
    @JacksonXmlProperty(localName = "rok")
    private int rok;
    @JacksonXmlProperty(localName = "wartosc")
    private double wartosc;
    @JacksonXmlProperty(localName = "flaga")
    private String flaga;
}
