package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "internet_access")
public class InternetAccess {

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getR2011() {
        return r2011;
    }

    public double getR2012() {
        return r2012;
    }

    public double getR2013() {
        return r2013;
    }

    public double getR2014() {
        return r2014;
    }

    public double getR2015() {
        return r2015;
    }

    public double getR2016() {
        return r2016;
    }

    public double getR2017() {
        return r2017;
    }

    public double getR2018() {
        return r2018;
    }

    public double getR2019() {
        return r2019;
    }

    public double getR2020() {
        return r2020;
    }

    public double getR2021() {
        return r2021;
    }

    public double getR2022() {
        return r2022;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double r2011;
    private double r2012;
    private double r2013;
    private double r2014;
    private double r2015;
    private double r2016;
    private double r2017;
    private double r2018;
    private double r2019;
    private double r2020;
    private double r2021;
    private double r2022;
}
