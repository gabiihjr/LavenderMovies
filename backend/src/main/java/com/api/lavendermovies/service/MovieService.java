package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.forms.CreateMovieForm;
import com.api.lavendermovies.dtos.GetMovieDto;
import com.api.lavendermovies.forms.UpdateMovieForm;
import com.api.lavendermovies.domain.models.Movie;
import com.api.lavendermovies.repository.ActorRepository;
import com.api.lavendermovies.repository.DirectorRepository;
import com.api.lavendermovies.repository.MovieRepository;
import com.api.lavendermovies.repository.WriterRepository;
import com.api.lavendermovies.config.ObjectMapper;
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
    @Autowired
    final WriterRepository writerRepository;
    @Autowired
    final ActorRepository actorRepository;

    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository, WriterRepository writerRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.writerRepository = writerRepository;
        this.actorRepository = actorRepository;
    }

    public CreateMovieForm save(CreateMovieForm movieForm) {

        var movie = ObjectMapper.map(movieForm, Movie.class);
        var director = directorRepository.findById(movieForm.getDirectorId()).orElseThrow(() -> new BusinessException("Director not found"));
        var writer = writerRepository.findById(movieForm.getWriterId()).orElseThrow(() -> new BusinessException("Writer not found"));
        var actorsList = actorRepository.findAll();

        movie.setDirector(director);
        movie.setWriter(writer);
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
        movie.setWriter(movie.getWriter());
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
