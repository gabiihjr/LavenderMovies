package com.api.lavendermovies.controller;

import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/person")
public class PersonController {
    @Autowired
    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonForm actorForm){
        return status(HttpStatus.CREATED).body(personService.save(actorForm));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<GetPersonDto>> findAllPeople(){
        return status(HttpStatus.OK).body(personService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOnePerson(@PathVariable(value = "id") UUID id){
        return status(HttpStatus.OK).body(personService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid PersonForm actorForm){
        return status(HttpStatus.OK).body(personService.update(actorForm, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") UUID id){
        personService.delete(id);
        return status(HttpStatus.OK).body("Person deleted successfully");
    }
}
