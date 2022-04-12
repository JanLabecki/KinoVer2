package org.example.kino.model;

import java.util.HashMap;

public interface Record {

    HashMap<String, String> getPropertiesForValidation();
    String toString();
}