package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetPersonFromMoviesDto {
    private UUID id;
    private String name;
    private int birthDate;
    private int gender;
    private String image;
    public Gender getGender() {
        return Gender.valueOf(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }
}
