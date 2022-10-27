package com.api.lavendermovies.domain.dtos;

import com.api.lavendermovies.domain.models.Movie;

import java.util.List;

public class GetDirectorDto {
    private String name;
    private int age;
    private String gender;
    private List<GetMovieDto> movie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<GetMovieDto> getMovie() {
        return movie;
    }

    public void setMovie(List<GetMovieDto> movie) {
        this.movie = movie;
    }
}
