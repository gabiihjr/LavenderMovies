package com.lavendermovies.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavendermovies.backend.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
