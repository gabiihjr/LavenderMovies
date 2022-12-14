package com.api.lavendermovies.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "director")
public class Director  extends Person {

    @OneToMany(mappedBy = "director")
    @Cascade(CascadeType.ALL)
    private List<Movie> movie;
}
