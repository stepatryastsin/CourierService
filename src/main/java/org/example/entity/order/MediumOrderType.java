package org.example.entity.order;

public class MediumOrderType implements OrderType {
    public static final String NAME = "MEDIUM";
    @Override public double getMaxWeight() { return 5.0; }
    @Override public String name() { return NAME; }
}
