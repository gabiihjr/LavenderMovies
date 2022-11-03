package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GetPersonDto {
    private UUID id;
    private String name;
    private int age;
    private int gender;
    private List<GetMovieFromActorsDto> movies;

    public Gender getGender() {
        return Gender.valueOf(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }
}
