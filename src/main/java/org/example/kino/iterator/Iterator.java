package org.example.kino.iterator;

public interface Iterator<T> {
    T getNext();
    T getCurrent();
    boolean hasNext();
}

