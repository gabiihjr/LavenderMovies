package com.api.lavendermovies.domain.models;

import com.api.lavendermovies.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String summary;

    @Column
    private double rating;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int releaseYear;

    @Column(nullable = false)
    private int genre;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    private Writer writer;

    @ManyToMany
    @JoinTable(name = "movies_actors",
    joinColumns = {@JoinColumn(name = "movie_id") },
    inverseJoinColumns = {@JoinColumn(name = "actor_id") })
    private List<Actor> actors;

    public Genre getGenre() {
        return Genre.valueOf(genre);
    }

    public void setGenre(Genre genre) {
        this.genre = genre.getCode();
    }
}
