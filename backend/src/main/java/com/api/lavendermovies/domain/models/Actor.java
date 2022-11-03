package com.api.lavendermovies.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor extends Person {
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}
