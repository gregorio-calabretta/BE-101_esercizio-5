package com.example.esercizio5.dto;

import lombok.Data;

@Data
public class ProfessionDtoResponse {
    private Integer id;
    private String name;

    public ProfessionDtoResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
