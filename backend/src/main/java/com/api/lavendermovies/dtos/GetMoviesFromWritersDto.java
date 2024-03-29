package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
    @Getter
    @Setter
    public class GetMoviesFromWritersDto {
        private UUID id;
        private String title;
        private String summary;
        private double rating;
        private int duration;
        private int releaseYear;
        private int genre;
        private String image;
        private GetPersonFromMoviesDto director;
        private List<GetPersonFromMoviesDto> actors;

        public Genre getGenre() {
            return Genre.valueOf(genre);
        }

        public void setGenre(Genre genre) {
            this.genre = genre.getCode();
        }
}
