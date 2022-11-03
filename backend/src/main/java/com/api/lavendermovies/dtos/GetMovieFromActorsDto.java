package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetMovieFromActorsDto {
    private UUID id;
    private String title;
    private String summary;
    private double rating;
    private int duration;
    private int releaseYear;
    private int genre;
    private GetPersonFromMoviesDto director;
    private GetPersonFromMoviesDto writer;

    public Genre getGenre() {
        return Genre.valueOf(genre);
    }

    public void setGenre(Genre genre) {
        this.genre = genre.getCode();
    }
}
