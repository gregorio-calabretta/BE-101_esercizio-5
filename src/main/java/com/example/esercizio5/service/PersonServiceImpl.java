package com.example.esercizio5.service;

import com.example.esercizio5.mapper.PersonMapper;
import com.example.esercizio5.dto.PersonDtoRequest;
import com.example.esercizio5.dto.PersonDtoResponse;
import com.example.esercizio5.model.Profession;
import com.example.esercizio5.repository.PersonRepository;
import com.example.esercizio5.model.Person;
import com.example.esercizio5.repository.ProfessionRepository;
import com.example.esercizio5.validator.Validate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ProfessionRepository professionRepository;
    private final PersonMapper personMapper;
    private final Validate validate;

    public PersonServiceImpl(PersonRepository personRepository,
                             ProfessionRepository professionRepository,
                             PersonMapper personMapper, Validate validate) {
        this.personRepository = personRepository;
        this.professionRepository = professionRepository;
        this.personMapper= personMapper;
        this.validate = validate;
    }

    public PersonDtoResponse createPerson(PersonDtoRequest personDtoRequest) throws Exception {
        Profession profession = professionRepository.findByName(personDtoRequest.getProfession());
        if (profession == null) {
            throw new Exception("Profession not found.");
        }
        Person person = Person.builder()
                .name(personDtoRequest.getName())
                .surname(personDtoRequest.getSurname())
                .profession(profession)
                .build();//new Person(personDto.getName(),personDto.getSurname());
        personRepository.save(person);
        return personMapper.map(person);
    }
    public List<PersonDtoResponse> getAllPeople(){
        List<Person> personList = personRepository.findAll();
        return personMapper.mapAll(personList);
    }

    public PersonDtoResponse getPersonById(UUID id){
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid uuid"));
        return personMapper.map(person);
    }
    public void deletePerson(UUID id){
         personRepository.deleteById(id);
    }

    public List<String> findByNameStartingWith(String startingLetter) {
        validate.isLetter(startingLetter);
        List<String> nameList = personRepository.findByNameStartingWith(startingLetter);
        if (nameList.isEmpty()) throw new IllegalArgumentException("Resource not found");
        return nameList;
    }
}
