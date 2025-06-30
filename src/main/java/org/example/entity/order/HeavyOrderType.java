package org.example.entity.order;

public class HeavyOrderType implements OrderType {
    public static final String NAME = "HEAVY";
    @Override public double getMaxWeight() { return 10.0; }
    @Override public String name() { return NAME; }
}