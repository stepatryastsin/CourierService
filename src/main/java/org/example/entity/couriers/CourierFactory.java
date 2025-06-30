package org.example.entity.couriers;
import org.example.entity.utils.Point;
import org.example.entity.utils.Time;

import org.example.entity.validate.CourierData;
import org.example.utils.GenerateID;

public class CourierFactory {
    private final GenerateID generateID = new GenerateID();
    private final org.example.entity.couriers.couriervalidate.CourierValidator validator = new org.example.entity.couriers.couriervalidate.CourierValidator();

    public Courier create(String       name,
                          CourierType  type,
                          double       speed,
                          double       loadCapacity,
                          Time         workInterval,
                          Point        location) {
        int id = generateID.getId();
        CourierData data = new CourierData(
                id, name, type, speed, loadCapacity, workInterval, location
        );
        validator.validate(data);
        return new Courier(
                id, name, type, speed, loadCapacity, workInterval, location,validator
        );
    }
}