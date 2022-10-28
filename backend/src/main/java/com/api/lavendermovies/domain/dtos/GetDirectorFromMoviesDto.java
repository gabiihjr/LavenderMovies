package com.api.lavendermovies.domain.dtos;

import com.api.lavendermovies.domain.enums.Gender;
import com.api.lavendermovies.domain.enums.Genre;

import java.util.List;
import java.util.UUID;

public class GetDirectorFromMoviesDto {
    private UUID id;
    private String name;
    private int age;
    private int gender;

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
}
