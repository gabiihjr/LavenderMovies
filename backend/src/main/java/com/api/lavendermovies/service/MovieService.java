package com.api.lavendermovies.service;

import com.api.lavendermovies.config.BusinessException;
import com.api.lavendermovies.domain.dtos.CreateMovieDto;
import com.api.lavendermovies.domain.entities.MovieModel;
import com.api.lavendermovies.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class MovieService {
    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieModel save(CreateMovieDto movieDto) {
        if (movieDto.getTitle() == null)
            throw new BusinessException("Field title is required.");
        var movie = new MovieModel();
        BeanUtils.copyProperties(movieDto, movie);
        movie.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return movieRepository.save(movie);
    }
}
