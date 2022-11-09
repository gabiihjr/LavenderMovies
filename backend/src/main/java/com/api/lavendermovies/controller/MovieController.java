package com.api.lavendermovies.controller;

import com.api.lavendermovies.forms.CreateMovieForm;
import com.api.lavendermovies.dtos.GetMovieDto;
import com.api.lavendermovies.forms.UpdateMovieForm;
import com.api.lavendermovies.service.MovieService;
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
@RequestMapping("/movie")
public class MovieController {

    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object> saveMovie(@RequestBody @Valid CreateMovieForm movieForm){
        return status(HttpStatus.CREATED).body(movieService.save(movieForm));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<GetMovieDto>> findAllMovies(){
        return status(HttpStatus.OK).body(movieService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneMovie(@PathVariable(value = "id") UUID id){
        return status(HttpStatus.OK).body(movieService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid UpdateMovieForm movieForm){
        return status(HttpStatus.OK).body(movieService.update(id, movieForm));
    };

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable(value = "id") UUID id){
        movieService.delete(id);
        return status(HttpStatus.OK).body("Movie deleted successfully");
    }
}
