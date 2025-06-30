package org.example.entity.couriers;

public class PedestrianCourierType implements CourierType {
    public static final String NAME = "PEDESTRIAN";
    @Override public String getTypeName()     { return "on foot"; }
    @Override public double getMaxSpeed()      { return 2.8; }
    @Override public double getMaxLoad()       { return 3.0; }
}
