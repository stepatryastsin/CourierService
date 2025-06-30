package org.example.entity.couriers;

public class CarCourierType implements CourierType{
    public static final String NAME = "CAR";
    @Override public String getTypeName()     { return "by car"; }
    @Override public double getMaxSpeed()      { return 16.0; }
    @Override public double getMaxLoad()       { return 10.0; }
}
