package org.example.kino.model;

public class Ticket {
    private static int counter = 1;
    private int id = counter++;
    private String type;
    private String subYN;
    private int row;
    private int seat;
    private int hall;
    private int price;


    public Ticket(String type, String subYN) {
        this.type = type;
        this.subYN = subYN;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubYN() {
        return subYN;
    }

    public void setSubYN(String subYN) {
        this.subYN = subYN;
    }

    public int getRow() {return row;}

    public void setRow(int row) {this.row = row;}

    public int getSeat() {return seat;}

    public void setSeat(int seat) {this.seat = seat;}

    public int getHall() {return hall;}

    public void setHall(int hall) {this.hall = hall;}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }
    public Ticket(String[] properties) {
            this.id = Integer.parseInt(properties[0]);
            this.type = properties[1];
            this.subYN = properties[2];
            this.row = Integer.parseInt(properties[3]);
            this.seat = Integer.parseInt(properties[4]);
            this.hall = Integer.parseInt(properties[5]);
            this.price = Integer.parseInt(properties[6]);
        }


    public Ticket(String type, String subYN, String row, String seat, String hall, String price) {
        this.type = type;
        this.subYN = subYN;
        this.row = Integer.parseInt(price);
        this.seat = Integer.parseInt(price);
        this.hall = Integer.parseInt(price);
        this.price = Integer.parseInt(price);
    }

    @Override

    public String toString() {return id + "," + type + "," + subYN + "," +row+ "," +seat+ "," +hall+ "," + price;}
}
