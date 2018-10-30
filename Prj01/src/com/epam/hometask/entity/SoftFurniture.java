package com.epam.hometask.entity;


public class SoftFurniture extends Furniture {

    private double minSquare;
    private double maxSquare;

    public SoftFurniture(String name, double minSquare, double maxSquare) {
        this.setName(name);
        if (minSquare > 0) {
            this.minSquare = minSquare;
        } else {
            throw new IllegalArgumentException("Minimal soft furniture square must be > 0");
        }
        if (maxSquare > minSquare) {
            this.maxSquare = maxSquare;
        } else {
            throw new IllegalArgumentException("Maximum soft furniture square must be > minimal square");
        }
    }

    public void setMinSquare(double minSquare) {
        this.minSquare = minSquare;
    }

    public void setMaxSquare(double maxSquare) {
        this.maxSquare = maxSquare;
    }

    public double getMinSquare() {
        return minSquare;
    }

    public double getMaxSquare() {
        return maxSquare;
    }

    public String toString() {
        return getName() + " (Square is between " + getMinSquare() + " m^2 and " + getMaxSquare() + " m^2)";
    }

}
