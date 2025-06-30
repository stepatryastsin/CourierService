package org.example.entity.order;

public class LightOrderType implements OrderType{
    public static final String NAME = "LIGHT";
    @Override public double getMaxWeight() { return 3.0; }
    @Override public String name() { return NAME; }
}
