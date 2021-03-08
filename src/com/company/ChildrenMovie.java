package com.company;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String name, String duration, String country, String genre){
        super(name, duration, country, genre);
    }
    @Override
    public void override(){
        System.out.println("subclass1");
    }
}
