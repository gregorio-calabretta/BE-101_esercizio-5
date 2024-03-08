package com.example.esercizio4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDtoRequest {
    private String name;
    private String surname;
    private String profession;

    public PersonDtoRequest(@JsonProperty("name") String name, @JsonProperty("surname") String surname, @JsonProperty("profession") String profession) {
        this.name = name;
        this.surname = surname;
        this.profession = profession;
    }
}
