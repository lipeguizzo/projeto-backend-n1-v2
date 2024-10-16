package org.example.entity;

public class Movie {
    private String name;
    private double price;
    private int minAge;

    public Movie() {
    }

    public Movie(String name, double price, int minAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}

