package org.example.kino.iterator;

import org.example.kino.model.MovieReservation;

public class MovieResIterator implements Iterator<MovieReservation>{
    private MovieResCollection movieResCollection;
    private int currentIndex;
    public MovieResIterator(MovieResCollection movieResCollection) {
        this.movieResCollection = movieResCollection;
        this.currentIndex = 0;
    }

    @Override
    public MovieReservation getNext() {
        currentIndex++;
        return movieResCollection.getMovieReservations().get(currentIndex);
    }

    @Override
    public MovieReservation getCurrent() {
        return movieResCollection.getMovieReservations().get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < movieResCollection.getMovieReservations().size();
    }
}
