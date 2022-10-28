package com.api.lavendermovies.domain.dtos;

import com.api.lavendermovies.domain.enums.Gender;

import java.util.List;
import java.util.UUID;

public class GetDirectorDto {
    private UUID id;
    private String name;
    private int age;
    private int gender;
    private List<GetMoviesFromDirectorDtos> movie;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public List<GetMoviesFromDirectorDtos> getMovie() {
        return movie;
    }

    public void setMovie(List<GetMoviesFromDirectorDtos> movie) {
        this.movie = movie;
    }
}
