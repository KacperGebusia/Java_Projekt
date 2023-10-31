package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "internet_access")
public class InternetAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JacksonXmlProperty(localName = "type")
    private String type;
    @JacksonXmlProperty(localName = "r2011")

    private double r2011;
    @JacksonXmlProperty(localName = "r2012")
    private double r2012;
    @JacksonXmlProperty(localName = "r2013")
    private double r2013;
    @JacksonXmlProperty(localName = "r2014")
    private double r2014;
    @JacksonXmlProperty(localName = "r2015")
    private double r2015;
    @JacksonXmlProperty(localName = "r2016")
    private double r2016;
    @JacksonXmlProperty(localName = "r2017")
    private double r2017;
    @JacksonXmlProperty(localName = "r2018")
    private double r2018;
    @JacksonXmlProperty(localName = "r2019")
    private double r2019;
    @JacksonXmlProperty(localName = "r2020")
    private double r2020;
    @JacksonXmlProperty(localName = "r2021")
    private double r2021;
    @JacksonXmlProperty(localName = "r2022")
    private double r2022;
}
