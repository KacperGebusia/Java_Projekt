package com.example.Java_Projekt.Models.Files;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "access_type")
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement
public class AccessType {
    @jakarta.persistence.Id
    private int Id;
    private String Name;
    private String Description;

}
