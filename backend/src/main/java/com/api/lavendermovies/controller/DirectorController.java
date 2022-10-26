package com.api.lavendermovies.controller;

import com.api.lavendermovies.domain.dtos.CreateDirectorDto;
import com.api.lavendermovies.domain.dtos.GetDirectorDto;
import com.api.lavendermovies.domain.models.Director;
import com.api.lavendermovies.service.DirectorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Object> saveDirector(@RequestBody @Valid CreateDirectorDto directorDto){
        return status(HttpStatus.CREATED).body(directorService.save(directorDto));
    }

    @GetMapping
    public ResponseEntity<List<GetDirectorDto>> findAllDirectors(){
        return status(HttpStatus.OK).body(directorService.findAll());
    }
}
