package org.example.kino;


import org.example.kino.console.ConsoleController;
import org.example.kino.database.CSVTicketDatabase;
import org.example.kino.database.CSVClientDatabase;
import org.example.kino.database.CSVReservationDatabase;
import org.example.kino.model.Ticket;
import org.example.kino.model.Client;
import org.example.kino.model.MovieReservation;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CSVClientDatabase csvClientDatabase = CSVClientDatabase.getInstance("clients.csv");
        CSVTicketDatabase csvTicketDatabase = CSVTicketDatabase.getInstance("Ticket.csv");
        CSVReservationDatabase csvReservationDatabase = CSVReservationDatabase.getInstance("reservationPosition.csv");
        /*List<Ticket> tickets = csvTicketDatabase.loadAllTickets();
        Ticket ticketWithMaxId = tickets.stream()
                .max(Comparator.comparingInt(ticket -> ticket.getId()))
                .get();
        Ticket.setCounter(ticketWithMaxId.getId() + 1);

        List<Client> clients = csvClientDatabase.loadAllClients();
        Ticket clientWithMaxId = tickets.stream()
                .max(Comparator.comparingInt(client -> client.getId()))
                .get();
        Client.setCounter(clientWithMaxId.getId() + 1);
        List<MovieReservation> movieReservations = csvReservationDatabase.loadAllReservationPositions();
        MovieReservation reservationPositionWithMaxId = movieReservations.stream()
                .max(Comparator.comparingInt(reservationPosition -> reservationPosition.getId()))
                .get();
        MovieReservation.setCounter(reservationPositionWithMaxId.getId() + 1); */
       ConsoleController consoleController = new ConsoleController();
       consoleController.Menu();

    }
}
