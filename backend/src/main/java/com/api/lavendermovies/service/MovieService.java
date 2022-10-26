package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.RequiredFieldException;
import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.domain.models.Movie;
import com.api.lavendermovies.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class MovieService {
    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(CreateMovieDto movieDto) {
        if (movieDto.getTitle() == null)
            throw new RequiredFieldException("title");
        var movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        movie.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return movieRepository.save(movie);
    }
}
