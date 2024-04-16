package com.slizokav.CrudSecurityRestApi.service;

import com.slizokav.CrudSecurityRestApi.model.Person;
import com.slizokav.CrudSecurityRestApi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(Person person) {
        person.setRole("ROLE_USER");
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }
}