package com.example.esercizio4.service;

import com.example.esercizio4.dto.PersonDtoRequest;
import com.example.esercizio4.dto.PersonDtoResponse;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    PersonDtoResponse createPerson(PersonDtoRequest personDtoRequest);
    List<PersonDtoResponse> getAllPeople();
    PersonDtoResponse getPersonById(UUID id);
    void deletePerson(UUID id);
}
