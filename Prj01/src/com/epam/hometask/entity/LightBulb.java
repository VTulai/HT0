package com.epam.hometask.entity;

public class LightBulb extends Facilities {

    private double illuminance;

    private static final int MIN_BULB_ILLUMINANCE = 50;
    private static final int MAX_BULB_ILLUMINANCE = 600;

    public LightBulb(double illuminance){
        this.setName("Light bulb");
        if (illuminance >= MIN_BULB_ILLUMINANCE && illuminance <= MAX_BULB_ILLUMINANCE){
            this.illuminance = illuminance;
        } else {
            throw new IllegalArgumentException("Illuminance is varying from " + MIN_BULB_ILLUMINANCE + " to " + MAX_BULB_ILLUMINANCE + "!");
        }
    }

    public double getIlluminance(){
        return illuminance;
    }
}
