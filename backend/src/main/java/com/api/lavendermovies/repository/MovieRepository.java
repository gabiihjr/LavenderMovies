package com.api.lavendermovies.repository;

import com.api.lavendermovies.domain.entities.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, UUID> {
}
