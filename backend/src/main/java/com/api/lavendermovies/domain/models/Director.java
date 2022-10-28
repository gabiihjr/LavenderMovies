package com.api.lavendermovies.domain.models;

import com.api.lavendermovies.domain.enums.Gender;
import com.api.lavendermovies.domain.enums.Genre;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "director")
public class Director implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int gender;

    @OneToMany(mappedBy = "director")
    @Cascade(CascadeType.ALL)
    private List<Movie> movie;

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

    public Genre getGender() {
        return Genre.valueOf(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
