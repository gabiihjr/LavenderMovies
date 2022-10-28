package com.api.lavendermovies.controller;

import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.domain.dtos.GetMovieDto;
import com.api.lavendermovies.domain.dtos.UpdateMovieDto;
import com.api.lavendermovies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<GetMovieDto>> findAllMovies(){
        return status(HttpStatus.OK).body(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneMovie(@PathVariable(value = "id") UUID id){
        return status(HttpStatus.OK).body(movieService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid UpdateMovieDto movieDto){
        return status(HttpStatus.OK).body(movieService.update(id, movieDto));
    };
}
