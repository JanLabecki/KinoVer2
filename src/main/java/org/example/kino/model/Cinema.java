package org.example.kino.model;

public class Cinema {
    private String street;
    private int streetNr;
    private Integer cinemaId;
    private String postalCode;
    private String city;

    public Cinema(String street, int streetNr, Integer cinemaId, String postalCode, String city) {
        this.street = street;
        this.streetNr = streetNr;
        this.cinemaId = cinemaId;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(int streetNr) {
        this.streetNr = streetNr;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Cinema() {
    }

    @Override
    public String toString() {
        return street + "," + streetNr + "," + cinemaId + "," + postalCode + "," + city + ",";
    }
}
