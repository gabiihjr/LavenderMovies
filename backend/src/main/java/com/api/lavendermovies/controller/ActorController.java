package com.api.lavendermovies.controller;

import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.service.ActorService;
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
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object> saveActor(@RequestBody @Valid PersonForm actorForm){
        return status(HttpStatus.CREATED).body(actorService.save(actorForm));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<GetPersonDto>> findAllActors(){
        return status(HttpStatus.OK).body(actorService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneActor(@PathVariable(value = "id") UUID id){
        return status(HttpStatus.OK).body(actorService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateActor(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid PersonForm actorForm){
        return status(HttpStatus.OK).body(actorService.update(actorForm, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteActor(@PathVariable(value = "id") UUID id){
        actorService.delete(id);
        return status(HttpStatus.OK).body("Actor deleted successfully");
    }
}
