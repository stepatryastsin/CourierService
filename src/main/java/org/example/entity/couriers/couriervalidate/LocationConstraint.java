package org.example.entity.couriers.couriervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.CourierData;

public class LocationConstraint implements Constraint<CourierData> {
    @Override public void check(CourierData d) {
        if (d.location() == null)
            throw new IllegalArgumentException("Location must not be null");
    }
}
