package com.example.esercizio4.service;

import com.example.esercizio4.mapper.PersonMapper;
import com.example.esercizio4.dto.PersonDtoRequest;
import com.example.esercizio4.dto.PersonDtoResponse;
import com.example.esercizio4.model.Profession;
import com.example.esercizio4.repository.PersonRepository;
import com.example.esercizio4.model.Person;
import com.example.esercizio4.repository.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ProfessionRepository professionRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository,
                             ProfessionRepository professionRepository,
                             PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.professionRepository = professionRepository;
        this.personMapper= personMapper;
    }

    public PersonDtoResponse createPerson(PersonDtoRequest personDtoRequest){
        Person person = Person.builder().name(personDtoRequest.getName()).surname(personDtoRequest.getSurname()).build();//new Person(personDto.getName(),personDto.getSurname());
        Profession profession = professionRepository.findByName(personDtoRequest.getProfession());
        person.addProfession(profession);
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

}
