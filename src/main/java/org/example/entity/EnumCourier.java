package org.example.entity;

public enum EnumCourier implements Vehicle {
    PEDESTRIAN("on foot", 2.8,  3.0),
    BICYCLE   ("by bike", 6.0,  5.0),
    CAR       ("by car", 16.0, 10.0);

    private final String name;
    private final double maxSpeed;
    private final double maxLoad;

    EnumCourier(String name, double maxSpeed, double maxLoad) {
        this.name     = name;
        this.maxSpeed = maxSpeed;
        this.maxLoad  = maxLoad;
    }

    @Override public double getMaxSpeed()  { return maxSpeed; }
    @Override public double getMaxLoad()   { return maxLoad; }
    @Override public String getTypeName()  { return name; }
}
