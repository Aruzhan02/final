package com.company;

public class Movie {
    private String name;
    private String time;
    private String country;
    private String genre;
    public Movie(String name, String time, String country, String genre){
        setName(name);
        setTime(time);
        setCountry(country);
        setGenre(genre);
    }
    public Movie(){

    }
    public void override(){
        System.out.println("Parentclass");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
