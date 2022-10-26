package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.RequiredFieldException;
import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.domain.models.Movie;
import com.api.lavendermovies.repository.DirectorRepository;
import com.api.lavendermovies.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class MovieService {
    @Autowired
    final MovieRepository movieRepository;
    @Autowired
    final DirectorRepository directorRepository;

    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public CreateMovieDto save(CreateMovieDto movieDto) {
        if (movieDto.getTitle() == null) throw new RequiredFieldException("title");
        var movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        var director = directorRepository.getReferenceById(movieDto.getDirectorId());
        movie.setDirector(director);
        movie.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        movieRepository.save(movie);
        return movieDto;
    }
}
