package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.RequiredFieldException;
import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.domain.dtos.GetMovieDto;
import com.api.lavendermovies.domain.models.Movie;
import com.api.lavendermovies.repository.DirectorRepository;
import com.api.lavendermovies.repository.MovieRepository;
import com.api.lavendermovies.utils.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

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

        var movie = ObjectMapper.map(movieDto, Movie.class);

        var director = directorRepository.getReferenceById(movieDto.getDirectorId());

        movie.setDirector(director);
        movie.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        movieRepository.save(movie);

        return movieDto;
    }

    public List<GetMovieDto> findAll() {
        var movieList = movieRepository.findAll();

        return ObjectMapper.mapAll(movieList, GetMovieDto.class);
    }

    public GetMovieDto findById(UUID id) {
        var movie = movieRepository.getReferenceById(id);

        return ObjectMapper.map(movie, GetMovieDto.class);
    }
}
