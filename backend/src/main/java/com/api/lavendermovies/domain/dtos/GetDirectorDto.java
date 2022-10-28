package com.api.lavendermovies.domain.dtos;

import com.api.lavendermovies.domain.enums.Gender;
import com.api.lavendermovies.domain.enums.Genre;

import java.util.List;

public class GetDirectorDto {
    private String name;
    private int age;
    private int gender;
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

    public Gender getGender() {
        return Gender.valueOf(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }

    public List<GetMovieDto> getMovie() {
        return movie;
    }

    public void setMovie(List<GetMovieDto> movie) {
        this.movie = movie;
    }
}
