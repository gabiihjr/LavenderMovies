package com.api.lavendermovies.domain.dtos;

import com.api.lavendermovies.domain.enums.Gender;

public class CreateDirectorDto {

    private String name;
    private int age;
    private int gender;

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
