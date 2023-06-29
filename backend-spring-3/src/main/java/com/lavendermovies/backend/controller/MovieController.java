package com.lavendermovies.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavendermovies.backend.dtos.MovieRecordDto;
import com.lavendermovies.backend.forms.MovieRecordForm;
import com.lavendermovies.backend.service.MovieService;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<MovieRecordDto>> findAllMovies() {
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }

    @PostMapping()
    public ResponseEntity<MovieRecordForm> saveMovie(@RequestBody MovieRecordForm form) {
        movieService.saveMovie(form);
        return ResponseEntity.ok().body(form);
    }
    
}
