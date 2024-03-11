package com.example.esercizio5.service;


import com.example.esercizio5.dto.ProfessionDtoRequest;
import com.example.esercizio5.dto.ProfessionDtoResponse;
import com.example.esercizio5.model.Profession;

import java.util.List;

public interface ProfessionService {
     ProfessionDtoResponse addProfession(ProfessionDtoRequest profession);
     Profession findByNameAndSurname(String name, String surname);
     ProfessionDtoResponse getProfessionById(Integer id);
     List<ProfessionDtoResponse> getAllProfessions();
     void  deleteById(Integer id);
     public void updateProfession(Integer id,String name);
}
