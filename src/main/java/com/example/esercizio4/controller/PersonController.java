package com.example.esercizio4.controller;

import com.example.esercizio4.dto.PersonDtoRequest;
import com.example.esercizio4.dto.PersonDtoResponse;
import com.example.esercizio4.model.Person;
import com.example.esercizio4.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/persons")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDtoResponse> createPerson(@RequestBody PersonDtoRequest person){
        PersonDtoResponse responseDTO  = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PersonDtoResponse>> getAllPeople(){
        List<PersonDtoResponse> personListDTOs = personService.getAllPeople();
        return ResponseEntity.status(HttpStatus.OK).body(personListDTOs);
    }

    @GetMapping(path = "{personUuid}")
    public ResponseEntity<PersonDtoResponse> getPersonById(@PathVariable("personUuid") UUID id){
        PersonDtoResponse responseDTO = personService.getPersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping(path = "{personUuid}")
    public void deletePersonById(@PathVariable("personUuid") UUID id){
        personService.deletePerson(id);
    }

}
