package com.api.lavendermovies.forms;

import com.api.lavendermovies.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateMovieForm {
    @NotBlank(message = "Field title is required")
    private String title;
    @NotBlank(message = "Field summary is required")
    private String summary;
    private double rating;
    @Min(value = 1, message = "Duration must have minimum value of 1")
    private int duration;
    @Min(value = 1895, message = "Release Year must have minimum value of 1895")
    private int releaseYear;
    @NotNull(message = "Field genre is required")
    private int genre;

    public Genre getGenre() {
        return Genre.valueOf(genre);
    }

    public void setGenre(Genre genre) {
        this.genre = genre.getCode();
    }
}
