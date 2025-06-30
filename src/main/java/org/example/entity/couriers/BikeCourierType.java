package org.example.entity.couriers;

public class BikeCourierType implements CourierType{
    public static final String NAME = "BICYCLE";
    @Override public String getTypeName()     { return "by bike"; }
    @Override public double getMaxSpeed()      { return 6.0; }
    @Override public double getMaxLoad()       { return 5.0; }
}
