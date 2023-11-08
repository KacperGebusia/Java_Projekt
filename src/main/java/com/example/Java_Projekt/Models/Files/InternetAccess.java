package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Table(name = "internet_access")
public class InternetAccess {

    public InternetAccess(Long id, String type, double r2011, double r2012, double r2013, double r2014, double r2015, double r2016, double r2017, double r2018, double r2019, double r2020, double r2021, double r2022) {
        this.id = id;
        this.type = type;
        this.r2011 = r2011;
        this.r2012 = r2012;
        this.r2013 = r2013;
        this.r2014 = r2014;
        this.r2015 = r2015;
        this.r2016 = r2016;
        this.r2017 = r2017;
        this.r2018 = r2018;
        this.r2019 = r2019;
        this.r2020 = r2020;
        this.r2021 = r2021;
        this.r2022 = r2022;
    }

    public InternetAccess() {
    }

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
