package org.example.entity.couriers.couriervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.CourierData;

public class SpeedConstraint implements Constraint<CourierData> {
    @Override public void check(CourierData d) {
        if (d.speed() <= 0 || d.speed() > d.type().getMaxSpeed()) {
            throw new IllegalArgumentException(String.format(
                    "Speed for %s must be >0 and ≤%.1f m/s",
                    d.type().getTypeName(), d.type().getMaxSpeed()));
        }
    }
}
