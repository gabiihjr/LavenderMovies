package com.lavendermovies.backend.forms;

public record MovieRecordForm(
        String title,
        String overview,
        int duration,
        int releaseDate,
        String posterPath,
        String tagline) {
}
