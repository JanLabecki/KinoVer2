package org.example.kino.iterator;

import org.example.kino.model.MovieReservation;

public class MovieResIterator implements Iterator<MovieReservation>{
    MovieResCollection movieResCollection;
    public MovieResIterator(MovieResCollection movieResCollection) {
        this.movieResCollection = movieResCollection
    }
}
