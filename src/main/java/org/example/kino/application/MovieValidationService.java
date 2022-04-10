package org.example.kino.application;

import org.example.kino.model.Movies;

public class MovieValidationService {
    public boolean validateMovieData(Movies movie) {
        if (movie.getTitle().isEmpty()) {
            return false;
        }

        if (movie.getStudio().isEmpty()) {
            return false;
        }

        return true;
    }
}
