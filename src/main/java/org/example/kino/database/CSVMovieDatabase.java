package org.example.kino.database;

import com.opencsv.CSVReader;
import org.example.kino.model.Movies;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVMovieDatabase {
    private static CSVMovieDatabase csvMoviesDatabase;
    private String fileName;

    public static CSVMovieDatabase getInstance(String fileName) {
        if (csvMoviesDatabase == null) {
            csvMoviesDatabase = new CSVMovieDatabase(fileName);
        }
        return csvMoviesDatabase;
    }

    private CSVMovieDatabase(String fileName) {
        this.fileName = fileName;
    }

    public void saveMoviePosition(Movies position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(position.toString() + System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movies>  loadAllClients() {
        List<String[]> parametersList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            parametersList = reader.readAll();
            //parametersList.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Movies> movie = parametersList.stream()
                .map((p) -> new Movies(p))
                .collect(Collectors.toList());

        return  movie;
    }

    public Movies getMovieById(int id) {
        return null;
    }



    }


