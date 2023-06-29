package com.lavendermovies.backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.lavendermovies.backend.models.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "people")
public class People implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String biography;
    private LocalDateTime birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String profession;
    private String placeOfBirth;
    private String image;
}
