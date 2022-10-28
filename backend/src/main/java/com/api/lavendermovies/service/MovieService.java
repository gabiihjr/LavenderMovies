package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.config.exceptions.RequiredFieldException;
import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.domain.dtos.GetMovieDto;
import com.api.lavendermovies.domain.dtos.UpdateMovieDto;
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

    public void requiredFieldExceptions(Object movieDto) {
        if (movieDto instanceof CreateMovieDto createMovieDto) {
            if (createMovieDto.getTitle() == null) throw new RequiredFieldException("title");
            if (createMovieDto.getSummary() == null) throw new RequiredFieldException("summary");
            if (createMovieDto.getDuration() == 0) throw new RequiredFieldException("duration");
            if (createMovieDto.getReleaseYear() == 0) throw new RequiredFieldException("release year");
            if (createMovieDto.getDirectorId() == null) throw new RequiredFieldException("director");
        }
        if (movieDto instanceof UpdateMovieDto updateMovieDto) {
            if (updateMovieDto.getTitle() == null) throw new RequiredFieldException("title");
            if (updateMovieDto.getSummary() == null) throw new RequiredFieldException("summary");
            if (updateMovieDto.getDuration() == 0) throw new RequiredFieldException("duration");
            if (updateMovieDto.getReleaseYear() == 0) throw new RequiredFieldException("release year");
        }
    }

    public void notFoundException(UUID id){
        var movieExists = movieRepository.findById(id);

        if (movieExists.isEmpty()) throw new BusinessException("Movie not found");
    }

    public CreateMovieDto save(CreateMovieDto movieDto) {
        requiredFieldExceptions(movieDto);

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
        notFoundException(id);
        var movie = movieRepository.getReferenceById(id);

        return ObjectMapper.map(movie, GetMovieDto.class);
    }

    public UpdateMovieDto update(UUID id, UpdateMovieDto movieDto) {
        notFoundException(id);
        requiredFieldExceptions(movieDto);

        var movie = movieRepository.getReferenceById(id);

        BeanUtils.copyProperties(movieDto, movie);

        movie.setId(movie.getId());
        movie.setCreatedAt(movie.getCreatedAt());
        movie.setDirector(movie.getDirector());
        movie.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        movieRepository.save(movie);

        return movieDto;
    }
}
