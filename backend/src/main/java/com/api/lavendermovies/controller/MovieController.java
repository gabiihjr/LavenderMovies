package com.api.lavendermovies.controller;

import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/movie")
public class MovieController {

    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping
    public ResponseEntity<Object> saveMovie(@RequestBody @Valid CreateMovieDto movieDto){
        return status(HttpStatus.CREATED).body(movieService.save(movieDto));
    }
}
