package org.example.kino.model;

public class Movies {
    private static int counter = 1;
    private int id = counter++;
    private String title;
    private Integer yearOfPro;
    private Integer ageOfRes;
    private String studio;

    public Movies(String title, Integer yearOfPro, Integer ageOfRes, String studio) {
    }

    public static void setCounter(int counter) {
        Movies.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPro() {
        return yearOfPro;
    }

    public void setYearOfPro(Integer yearOfPro) {
        this.yearOfPro = yearOfPro;
    }

    public Integer getAgeOfRes() {
        return ageOfRes;
    }

    public void setAgeOfRes(Integer ageOfRes) {
        this.ageOfRes = ageOfRes;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Movies(String[] properties) {
        this.id = Integer.parseInt(properties[0]);
        this.title = properties[1];
        this.yearOfPro = Integer.parseInt(properties[0]);
        this.ageOfRes = Integer.parseInt(properties[0]);
        this.studio = properties [3];
    }

    public Movies() {
    }

    public Movies(String title, String studio) {
        this.title = title;
        this.studio = studio;
    }


    @Override

    public String toString() {
        return id + "," + title + "," + yearOfPro + "," + ageOfRes + "," +studio;
    }

}
