package com.epam.hometask.entity;


public class Furniture extends Facilities {

    private double square;

    public Furniture(){}

    public Furniture(String name, double square) {
        this.setName(name);
        if (square > 0) {
            this.square = square;
        } else {
            throw new IllegalArgumentException("Furniture square can't be less than zero");
        }
    }

    public double getSquare() {
        return square;
    }

    public String toString() {
        return getName() + " (Square is " + getSquare() + " m^2)";
    }
}
