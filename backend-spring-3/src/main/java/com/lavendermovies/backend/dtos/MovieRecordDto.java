package com.lavendermovies.backend.dtos;

import java.util.List;
import java.util.UUID;

import com.lavendermovies.backend.models.Genre;

public record MovieRecordDto(
        UUID id,
        String title,
        String overview,
        int duration,
        int releaseDate,
        List<Genre> genres,
        String posterPath,
        String tagline) {
}
