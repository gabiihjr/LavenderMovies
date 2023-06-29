package com.lavendermovies.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavendermovies.backend.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
