package com.epam.hometask.entity;


import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private double square;
    private int amountWindows;
    private List<Facilities> facilitiesList;
    private double illuminance;
    private double occupiedArea;
    private int amountLightBulb;

    public Room(String name, double square, int amountWindows) {
        this.name = name;
        if(square > 0){
            this.square = square;
        } else {
            throw new IllegalArgumentException("Room square must be above zero");
        }
        if(amountWindows >= 0){
            this.amountWindows = amountWindows;
        } else {
            throw new IllegalArgumentException("Windows amount can't be less than zero");
        }
        facilitiesList = new ArrayList<Facilities>();
        illuminance = 0;
    }

    public void add(Facilities fac) {
        facilitiesList.add(fac);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setAmountWindows(int amountWindows) {
        this.amountWindows = amountWindows;
    }

    public void setFacilitiesList(List<Facilities> facilitiesList) {
        this.facilitiesList = facilitiesList;
    }

    public void setIlluminance(double illuminance) {
        this.illuminance = illuminance;
    }

    public int getAmountLightBulb() {
        return amountLightBulb;
    }

    public String getName(){
        return name;
    }

    public List<Facilities> getFacilitiesList() {
        return facilitiesList;
    }

    public double getSquare(){
        return square;
    }

    public int getAmountWindows(){
        return amountWindows;
    }

    public double getIlluminance() {
        if(illuminance == 0) {
            for (Facilities f: facilitiesList) {
                if (f instanceof LightBulb){
                    amountLightBulb++;
                    illuminance += ((LightBulb) f).getIlluminance();
                }
            }
            illuminance += amountWindows * new Window().getIlluminance();
        }
        return illuminance;
    }

    public double getOccupiedArea() {
        if(occupiedArea == 0) {
            for (Facilities f: facilitiesList) {
                if (f instanceof Furniture){
                    occupiedArea += ((Furniture) f).getSquare();
                }
            }
        }
        return occupiedArea;
    }
}
