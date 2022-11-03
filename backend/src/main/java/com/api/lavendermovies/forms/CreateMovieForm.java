package com.api.lavendermovies.forms;

import com.api.lavendermovies.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreateMovieForm {
    @NotBlank(message = "Field title is required")
    private String title;
    @NotBlank(message = "Field summary is required")
    private String summary;
    private double rating;
    @Min(value = 1, message = "Duration must have minimum value of 1")
    private int duration;
    @Min(value = 1895, message = "Release Year must have minimum value of 1895")
    private int releaseYear;
    private int genre;
    @NotNull(message = "Field director is required")
    private UUID directorId;
    @NotNull(message = "Field writer is required")
    private UUID writerId;
    @NotNull(message = "Field actors is required")
    private List<UUID> actorsIds;

    public Genre getGenre() {
        return Genre.valueOf(genre);
    }

    public void setGenre(Genre genre) {
        this.genre = genre.getCode();
    }
}
