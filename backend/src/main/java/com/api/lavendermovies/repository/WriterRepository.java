package com.api.lavendermovies.repository;

import com.api.lavendermovies.domain.models.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WriterRepository extends JpaRepository<Writer, UUID> {
}
