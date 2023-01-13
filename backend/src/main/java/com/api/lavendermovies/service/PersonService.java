package com.api.lavendermovies.service;

import com.api.lavendermovies.config.ObjectMapper;
import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.domain.models.Person;
import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    @Autowired
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonForm save(PersonForm personForm) {
        var person = ObjectMapper.map(personForm, Person.class);
        person.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        personRepository.save(person);

        return personForm;
    }

    public List<GetPersonDto> findAll() {
        var personList = personRepository.findAll();

        return ObjectMapper.mapAll(personList, GetPersonDto.class);
    }

    public GetPersonDto findById(UUID id) {
        var person = personRepository.findById(id).orElseThrow(() -> new BusinessException("Person not found"));

        return ObjectMapper.map(person, GetPersonDto.class);
    }

    public PersonForm update(PersonForm personForm, UUID id) {
        var person = personRepository.findById(id).orElseThrow(() -> new BusinessException("Person not found"));

        BeanUtils.copyProperties(personForm, person);

        person.setId(person.getId());
        person.setCreatedAt(person.getCreatedAt());
        person.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        personRepository.save(person);

        return personForm;
    }

    public void delete(UUID id) {
        var person = personRepository.findById(id).orElseThrow(() -> new BusinessException("Person not found"));

        personRepository.delete(person);
    }
}
