package com.company;

public class AdultMovie extends Movie{
    public AdultMovie(String name, String duration, String country, String genre){
        super(name, duration, country, genre);
    }
    @Override
    public void override() {
        System.out.println("subclass2");
    }
}
