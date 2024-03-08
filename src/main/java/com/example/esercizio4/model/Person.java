package com.example.esercizio4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private Profession profession;


    public void addProfession(Profession profession){
        this.profession = profession;
    }

}
