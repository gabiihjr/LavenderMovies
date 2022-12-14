package com.api.lavendermovies.controller;

import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.service.DirectorService;
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
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object> saveDirector(@RequestBody @Valid PersonForm directorForm){
        return status(HttpStatus.CREATED).body(directorService.save(directorForm));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<GetPersonDto>> findAllDirectors(){
        return status(HttpStatus.OK).body(directorService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneDirector(@PathVariable(value = "id") UUID id){
        return status(HttpStatus.OK).body(directorService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDirector(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid PersonForm directorForm){
        return status(HttpStatus.OK).body(directorService.update(directorForm, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDirector(@PathVariable(value = "id") UUID id){
        directorService.delete(id);
        return status(HttpStatus.OK).body("Director deleted successfully");
    }
}
