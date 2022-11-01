package com.api.lavendermovies.dtos;

import com.api.lavendermovies.enums.Gender;
import com.api.lavendermovies.forms.DirectorForm;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetActorFromMoviesDto {
    private UUID id;
    private String name;
    private int age;
    private int gender;

    public Gender getGender() {
        return Gender.valueOf(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }
}
