package com.api.lavendermovies.service;

import com.api.lavendermovies.config.ObjectMapper;
import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.domain.models.Movie;
import com.api.lavendermovies.domain.models.Person;
import com.api.lavendermovies.dtos.GetMovieDto;
import com.api.lavendermovies.forms.CreateMovieForm;
import com.api.lavendermovies.forms.UpdateMovieForm;
import com.api.lavendermovies.repository.MovieRepository;
import com.api.lavendermovies.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    final MovieRepository movieRepository;
    @Autowired
    final PersonRepository personRepository;

    public MovieService(MovieRepository movieRepository, PersonRepository personRepository) {
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;
    }

    public CreateMovieForm save(CreateMovieForm movieForm) {

        var movie = ObjectMapper.map(movieForm, Movie.class);
        var director = personRepository.findById(movieForm.getDirectorId()).orElseThrow(() -> new BusinessException("Director not found"));
        var writersList = new ArrayList<Person>();
        var actorsList = new ArrayList<Person>();

        for(UUID writer : movieForm.getWritersIds()) {
            var person = personRepository.findById(writer).orElseThrow(() -> new BusinessException("Writer not found"));
            writersList.add(person);
        }
        for(UUID actor : movieForm.getActorsIds()) {
            var person = personRepository.findById(actor).orElseThrow(() -> new BusinessException("Actor not found"));
            actorsList.add(person);
        }

        movie.setDirector(director);
        movie.setWriters(writersList);
        movie.setActors(actorsList);
        movie.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        movieRepository.save(movie);

        return movieForm;
    }

    public List<GetMovieDto> findAll() {
        var movieList = movieRepository.findAll();

        return ObjectMapper.mapAll(movieList, GetMovieDto.class);
    }

    public GetMovieDto findById(UUID id) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new BusinessException("Movie not found"));

        return ObjectMapper.map(movie, GetMovieDto.class);
    }

    public UpdateMovieForm update(UUID id, UpdateMovieForm movieForm) {

        var movie = movieRepository.findById(id).orElseThrow(() -> new BusinessException("Movie not found"));

        BeanUtils.copyProperties(movieForm, movie);

        movie.setId(movie.getId());
        movie.setCreatedAt(movie.getCreatedAt());
        movie.setDirector(movie.getDirector());
        movie.setWriters(movie.getWriters());
        movie.setActors(movie.getActors());
        movie.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        movieRepository.save(movie);

        return movieForm;
    }

    public void delete(UUID id) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new BusinessException("Movie not found"));

        movieRepository.delete(movie);
    }
}
