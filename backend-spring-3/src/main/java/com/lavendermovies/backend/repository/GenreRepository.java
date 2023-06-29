package com.lavendermovies.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavendermovies.backend.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
