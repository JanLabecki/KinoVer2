package org.example.kino.application;


import org.example.kino.database.CSVMovieDatabase;
import org.example.kino.database.CSVTicketDatabase;
import org.example.kino.database.CSVClientDatabase;
import org.example.kino.database.CSVReservationDatabase;
import org.example.kino.iterator.MovieResCollection;
import org.example.kino.model.Movies;
import org.example.kino.model.Ticket;
import org.example.kino.model.Client;
import org.example.kino.model.MovieReservation;

import java.util.List;

public class ReservationPositionService {
    private final CSVReservationDatabase csvReservationDatabase;
    private final CSVClientDatabase csvClientDatabase;
    private final CSVTicketDatabase csvTicketDatabase;
    private final CSVMovieDatabase csvMovieDatabase;
    private final TicketValidationService ticketValidationService;
    private final TicketCostCalculator ticketCostCalculator;
    private final ClientValidationService clientValidationService;
    private final ReservationValidationService reservationValidationService;
    private final MovieValidationService movieValidationService;

    public ReservationPositionService() {
        csvReservationDatabase = CSVReservationDatabase.getInstance("reservationPosition.csv");
        csvClientDatabase = CSVClientDatabase.getInstance("clients.csv");
        csvTicketDatabase = CSVTicketDatabase.getInstance("Ticket.csv");
        csvMovieDatabase = CSVMovieDatabase.getInstance("Movie.csv");
        ticketValidationService = new TicketValidationService();
        ticketCostCalculator = new TicketCostCalculatorAdapter();
        clientValidationService = new ClientValidationService();
        reservationValidationService = new ReservationValidationService();
        movieValidationService = new MovieValidationService();
    }

    public void resMovie(MovieReservation movieReservation){
        movieReservation.setPaid(false);
        Ticket ticket = csvTicketDatabase.getTicketById(movieReservation.getMovieId());
        movieReservation.setTotalPrice((int) ticketCostCalculator.calculateTicketCost(movieReservation.getTicketAmount()));
        System.out.println(movieReservation.getTotalPrice());
        if (reservationValidationService.validateReservationData(movieReservation)) {
            csvReservationDatabase.saveReservationPosition(movieReservation);
        }
        else  {
            System.out.println("błąd");
        }
    }
    public void addClient(Client client) {
        if (clientValidationService.validateClientData(client)) {
            csvClientDatabase.saveClientPosition(client);}
        else  {
            System.out.println("błąd");
        }
    }

    public void addMovie(Movies movie) {
        if (movieValidationService.validateMovieData(movie)) {
            csvMovieDatabase.saveMoviePosition(movie);}
        else  {
            System.out.println("błąd");
        }
    }

    public void addTicket(Ticket ticket) {
        if(ticketValidationService.validateTicketData(ticket)) {
            csvTicketDatabase.saveTicketPosition(ticket);
        }
        else {
            System.out.println("błąd");
        }
    }

    public MovieResCollection showAllReservationPositions(){
        return new MovieResCollection (csvReservationDatabase.loadAllReservationPositions());
    }
}
