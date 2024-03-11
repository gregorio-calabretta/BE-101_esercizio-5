package com.example.esercizio5.service;

import com.example.esercizio5.dto.PersonDtoRequest;
import com.example.esercizio5.dto.PersonDtoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    PersonDtoResponse createPerson(PersonDtoRequest personDtoRequest) throws Exception;
    List<PersonDtoResponse> getAllPeople();
    PersonDtoResponse getPersonById(UUID id);
    void deletePerson(UUID id);
   List<String> findByNameStartingWith(String startingLetter);
}
