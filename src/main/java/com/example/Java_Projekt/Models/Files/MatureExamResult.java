package com.example.Java_Projekt.Models.Files;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mature_exam_results")
public class MatureExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa_zmiennej;
    private String rodzaj_egzaminu;
    private String poziom_egzaminu;
    private String przedmiot;
    private String plec;
    private String typ_informacji_z_jednostka_miary;
    private int rok;
    private double wartosc;
    private String flaga = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa_zmiennej() {
        return nazwa_zmiennej;
    }

    public void setNazwa_zmiennej(String nazwa_zmiennej) {
        this.nazwa_zmiennej = nazwa_zmiennej;
    }

    public String getRodzaj_egzaminu() {
        return rodzaj_egzaminu;
    }

    public void setRodzaj_egzaminu(String rodzaj_egzaminu) {
        this.rodzaj_egzaminu = rodzaj_egzaminu;
    }

    public String getPoziom_egzaminu() {
        return poziom_egzaminu;
    }

    public void setPoziom_egzaminu(String poziom_egzaminu) {
        this.poziom_egzaminu = poziom_egzaminu;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getTyp_informacji_z_jednostka_miary() {
        return typ_informacji_z_jednostka_miary;
    }

    public void setTyp_informacji_z_jednostka_miary(String typ_informacji_z_jednostka_miary) {
        this.typ_informacji_z_jednostka_miary = typ_informacji_z_jednostka_miary;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public String getFlaga() {
        return flaga;
    }

    public void setFlaga(String flaga) {
        this.flaga = flaga;
    }
}
