package org.example.kino.iterator;

import org.example.kino.model.MovieReservation;

import java.util.List;

public class MovieResCollection implements Collection<MovieReservation>{

    List<MovieReservation> movieReservations;

    public MovieResCollection(List<MovieReservation> movieReservations) {
        this.movieReservations = movieReservations;
    }

        @Override
        public Iterator<MovieReservation> createIterator() {
            return new MovieResIterator( this);
        }

        public List<MovieReservation> getMovieReservations() { return movieReservations; }
}
