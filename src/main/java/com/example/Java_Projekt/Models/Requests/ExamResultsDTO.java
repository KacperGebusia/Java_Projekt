package com.example.Java_Projekt.Models.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamResultsDTO {
    public String plec;
    public String poziom_egzaminu;
    public String przedmiot;
    public String rodzaj_egzaminu;
    public int rok;
    public Double wartosc;
}
