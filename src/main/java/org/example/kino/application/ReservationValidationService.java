package org.example.kino.application;

import org.example.kino.model.MovieReservation;

public class ReservationValidationService {

    public boolean validateReservationData(MovieReservation movieReservation) {
        if (movieReservation.getMovieId() == 0) {
            return false;
        }
        return true;
    }
}
