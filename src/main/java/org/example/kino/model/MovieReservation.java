package org.example.kino.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class MovieReservation implements Record{

    private static int counter = 1;
    private int id;
    private int movieId;
    private LocalDateTime startScreening;
    private int clientId;
    private int ticketAmount;
    int totalPrice;
    boolean paid;

    public MovieReservation(int movieId, LocalDateTime startScreening, int clientId, int ticketAmount) {
        this.id = counter++;
        this.movieId = movieId;
        this.startScreening = startScreening;
        this.clientId = clientId;
        this.ticketAmount = ticketAmount;
    }

    public MovieReservation(String[] properties) {
        this.id = Integer.parseInt(properties[0]);
        this.movieId = Integer.parseInt(properties[1]);
        this.startScreening = LocalDateTime.parse(properties[2]);
        this.clientId = Integer.parseInt(properties[3]);
        this.totalPrice = Integer.parseInt(properties[4]);
        this.paid = Boolean.parseBoolean(properties[5]);
        this.ticketAmount = Integer.parseInt(properties[6]);


    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public static void setCounter(int counter) {
        MovieReservation.counter = counter;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean ifPaid() { return paid; }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartScreening() {
        return startScreening;
    }

    public void setStartScreening(LocalDateTime startScreening) {
        this.startScreening = startScreening;
    }

    public HashMap<String, String> getPropertiesForValidation() {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("movieId", Integer.toString(movieId));
        properties.put("startScreening", startScreening.toString());
        properties.put("clientId", Integer.toString(clientId));
        properties.put("totalPrice", Integer.toString(totalPrice));
        properties.put("paid", Boolean.toString(paid));
        properties.put("ticketAmount", Integer.toString(ticketAmount));
        return properties;
    }

    @Override
    public String toString() {
        return id + "," + movieId + "," + startScreening + ","  + clientId + "," + totalPrice + "," + paid + ","+ticketAmount;
    }
}