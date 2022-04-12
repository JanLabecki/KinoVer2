package org.example.kino.template;

import org.example.kino.database.CSVReservationDatabase;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class AddMovieRes extends AddRes{

    CSVReservationDatabase database;

    public AddMovieRes(CSVReservationDatabase database) {
        this.database = database;
    }

    @Override
    public boolean validateData(HashMap<String, String> properties) {
        String startScreeningString = properties.get("startScreening");
        LocalDateTime startScreening = LocalDateTime.parse(startScreeningString);
        if(LocalDateTime.now().isAfter(startScreening)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void saveToDatabase(String csv) {
        database.saveReservationPosition(csv);
    }
}
