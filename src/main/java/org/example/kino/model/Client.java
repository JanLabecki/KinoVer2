package org.example.kino.model;

public class Client {
    private static int counter = 1;
    private int id = counter++;
    private String name;
    private String surname;
    private String email;

    public static void setCounter(int counter) {
        Client.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(String[] properties) {
        this.id = Integer.parseInt(properties[0]);
        this.name = properties[1];
        this.surname = properties[2];
        this.email = properties [3];
    }

    public Client() {
    }

    public Client(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    @Override

    public String toString() {
        return id + "," + name + "," + surname + "," + email;
    }

}
