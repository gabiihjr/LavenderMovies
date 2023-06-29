package com.lavendermovies.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavendermovies.backend.dtos.MovieRecordDto;
import com.lavendermovies.backend.forms.MovieRecordForm;
import com.lavendermovies.backend.models.Movie;
import com.lavendermovies.backend.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieRecordDto> findAllMovies() {
        List<Movie> movies = this.movieRepository.findAll();
        List<MovieRecordDto> moviesDto = new ArrayList<>();
        BeanUtils.copyProperties(movies, moviesDto);
        return moviesDto;
    }

    public MovieRecordForm saveMovie(MovieRecordForm movieForm) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieForm, movie);
        this.movieRepository.save(movie);
        return movieForm;
    }

}
