package com.api.lavendermovies.controller;

import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.service.WriterService;
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
@RequestMapping("/writer")
public class WriterController {
    @Autowired
    final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object> saveWriter(@RequestBody @Valid PersonForm writerForm){
        return status(HttpStatus.CREATED).body(writerService.save(writerForm));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<GetPersonDto>> findAllWriters(){
        return status(HttpStatus.OK).body(writerService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneWriter(@PathVariable(value = "id") UUID id){
        return status(HttpStatus.OK).body(writerService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWriter(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid PersonForm writerForm){
        return status(HttpStatus.OK).body(writerService.update(writerForm, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWriter(@PathVariable(value = "id") UUID id){
        writerService.delete(id);
        return status(HttpStatus.OK).body("Writer deleted successfully");
    }
}
