package com.epam.hometask.entity;


public class Window extends Facilities {

    private int illuminance;

    public Window(){
        this.setName("Window");
        this.illuminance = 700;
    }

    public int getIlluminance(){
        return illuminance;
    }
}
