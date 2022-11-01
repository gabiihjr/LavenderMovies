package com.api.lavendermovies.forms;

import com.api.lavendermovies.enums.Genre;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateMovieForm {
    @NotBlank(message = "Field title is required")
    private String title;
    @NotBlank(message = "Field summary is required")
    private String summary;
    private double rating;
    @Min(value = 1)
    private int duration;
    @Min(value = 1895)
    private int releaseYear;
    @NotNull(message = "Field genre is required")
    private int genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return Genre.valueOf(genre);
    }

    public void setGenre(Genre genre) {
        this.genre = genre.getCode();
    }
}
