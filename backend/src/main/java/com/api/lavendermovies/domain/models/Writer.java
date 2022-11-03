package com.api.lavendermovies.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "writer")
public class Writer extends Person {
    @OneToMany(mappedBy = "writer")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Movie> movie;
}
