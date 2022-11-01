package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.config.exceptions.RequiredFieldException;
import com.api.lavendermovies.forms.CreateMovieForm;
import com.api.lavendermovies.dtos.GetMovieDto;
import com.api.lavendermovies.forms.UpdateMovieForm;
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
        if (movieDto instanceof CreateMovieForm createMovieDto) {
            if (createMovieDto.getTitle() == null) throw new RequiredFieldException("title");
            if (createMovieDto.getSummary() == null) throw new RequiredFieldException("summary");
            if (createMovieDto.getDuration() == 0) throw new RequiredFieldException("duration");
            if (createMovieDto.getReleaseYear() == 0) throw new RequiredFieldException("release year");
            if (createMovieDto.getDirectorId() == null) throw new RequiredFieldException("director");
        }
        if (movieDto instanceof UpdateMovieForm updateMovieForm) {
            if (updateMovieForm.getTitle() == null) throw new RequiredFieldException("title");
            if (updateMovieForm.getSummary() == null) throw new RequiredFieldException("summary");
            if (updateMovieForm.getDuration() == 0) throw new RequiredFieldException("duration");
            if (updateMovieForm.getReleaseYear() == 0) throw new RequiredFieldException("release year");
        }
    }

    public CreateMovieForm save(CreateMovieForm movieDto) {
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
        var movie = movieRepository.findById(id).orElseThrow(() -> new BusinessException("Movie not found"));

        return ObjectMapper.map(movie, GetMovieDto.class);
    }

    public UpdateMovieForm update(UUID id, UpdateMovieForm movieDto) {
        requiredFieldExceptions(movieDto);

        var movie = movieRepository.findById(id).orElseThrow(() -> new BusinessException("Movie not found"));

        BeanUtils.copyProperties(movieDto, movie);

        movie.setId(movie.getId());
        movie.setCreatedAt(movie.getCreatedAt());
        movie.setDirector(movie.getDirector());
        movie.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        movieRepository.save(movie);

        return movieDto;
    }

    public void delete(UUID id) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new BusinessException("Movie not found"));

        movieRepository.delete(movie);
    }
}
