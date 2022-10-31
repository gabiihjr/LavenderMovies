package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Genre;

import java.util.UUID;

public class GetMoviesFromDirectorDtos {
    private UUID id;
    private String title;
    private String summary;
    private double rating;
    private int duration;
    private int releaseYear;
    private int genre;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
