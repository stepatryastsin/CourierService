package org.example.entity.couriers.couriervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.CourierData;

public class NameConstraint implements Constraint<CourierData> {
    @Override public void check(CourierData d) {
        if (d.name() == null || d.name().isBlank())
            throw new IllegalArgumentException("Name must not be empty");
    }
}
