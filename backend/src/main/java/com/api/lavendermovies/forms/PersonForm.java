package com.api.lavendermovies.forms;

import com.api.lavendermovies.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PersonForm {
    @NotBlank(message = "Field name is required")
    private String name;
    @Min(value = 1800, message = "birthDate must have minimum value of 1800")
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
