package com.example.esercizio4.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profession")
public class Profession {
    @Id
    private Integer id;
    private String name;

    public Profession(@JsonProperty Integer id,@JsonProperty String name) {
        this.id = id;
        this.name = name;
    }
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private List<Person> person;
}
