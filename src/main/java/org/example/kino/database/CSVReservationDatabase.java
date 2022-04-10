package org.example.kino.database;

import com.opencsv.CSVReader;
import org.example.kino.model.MovieReservation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReservationDatabase {

    private static CSVReservationDatabase csvReservationDatabase;
    private String fileName;

    private CSVReservationDatabase(String fileName) {this.fileName = fileName;}

    public static CSVReservationDatabase getInstance(String fileName) {
        if(csvReservationDatabase == null) {
            csvReservationDatabase = new CSVReservationDatabase(fileName);
        }
        return csvReservationDatabase;
    }


    public void saveReservationPosition(MovieReservation position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(position.toString() + System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MovieReservation>  loadAllReservationPositions() {
        List<String[]> parametersList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            parametersList = reader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<MovieReservation> movieReservations = parametersList.stream()
                .map((p) -> new MovieReservation(p))
                .collect(Collectors.toList());
        return movieReservations;
    }
}
