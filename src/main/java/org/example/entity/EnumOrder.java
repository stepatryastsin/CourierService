package org.example.entity;

public enum EnumOrder {
    LIGHT(3.0),
    MEDIUM(5.0),
    HARD(10.0);

    private final double maxWeight;

    EnumOrder(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    public double getMaxWeight() {
        return maxWeight;
    }
}