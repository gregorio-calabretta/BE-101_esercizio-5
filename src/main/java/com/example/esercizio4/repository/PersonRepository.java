package com.example.esercizio4.repository;

import com.example.esercizio4.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person,UUID> {
    Person save(Person person);
    List<Person> findAll();
    void deleteById(UUID id);
    Optional<Person> findById(UUID id);
    Person findByNameAndSurname(String name, String surname);
}
