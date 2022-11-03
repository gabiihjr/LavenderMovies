package com.api.lavendermovies.repository;

import com.api.lavendermovies.domain.models.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WriterRepository extends JpaRepository<Writer, UUID> {
}
