package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GetDirectorDto {
    private UUID id;
    private String name;
    private int age;
    private int gender;
    private List<GetMoviesFromDirectorDtos> movie;

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
