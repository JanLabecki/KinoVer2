package org.example.kino.database;

import com.opencsv.CSVReader;
import org.example.kino.model.Ticket;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVTicketDatabase {
    private static CSVTicketDatabase csvTicketDatabase;
    private String fileName;

    public static CSVTicketDatabase getInstance(String fileName) {
        if (csvTicketDatabase ==null) {
            csvTicketDatabase = new CSVTicketDatabase(fileName);
        }
        return csvTicketDatabase;
    }

    private CSVTicketDatabase(String fileName) {this.fileName = fileName;}

    public void saveTicketPosition(Ticket position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(position.toString() + System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> loadAllTickets() {
        List<String[]> parametersList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            parametersList = reader.readAll();
            //parametersList.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Ticket> ticket = parametersList.stream()
                .map((p) -> new Ticket(p))
                .collect(Collectors.toList());

        return ticket;
    }

    public Ticket getTicketById(int id) {
        List<Ticket> tickets = loadAllTickets();

        List<Ticket> ticketsFiltered = tickets.stream().filter((ticket) -> ticket.getId()==id).collect(Collectors.toList());
        if (ticketsFiltered.isEmpty()) {
            return new Ticket("", "");
        } else {
            return ticketsFiltered.get(0);
        }
    }
}
