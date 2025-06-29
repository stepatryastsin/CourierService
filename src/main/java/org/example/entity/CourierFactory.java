package org.example.entity;
import org.example.utils.GenerateID;

public class CourierFactory {
    private final GenerateID generator;

    public CourierFactory() {
        this.generator = new GenerateID();
    }
    public Courier create(String name,
                          Vehicle vehicle,
                          double speed,
                          double loadCapacity,
                          String workStart,
                          String workEnd,
                          Point location) {
        int id = generator.getId();
        return new Courier(id, name, vehicle, speed, loadCapacity, workStart, workEnd, location);
    }
}
