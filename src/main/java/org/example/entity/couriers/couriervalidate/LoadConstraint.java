package org.example.entity.couriers.couriervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.CourierData;

public class LoadConstraint implements Constraint<CourierData> {
    @Override public void check(CourierData d) {
        if (d.loadCapacity() <= 0 || d.loadCapacity() > d.type().getMaxLoad()) {
            throw new IllegalArgumentException(String.format(
                    "Load for %s must be >0 and ≤%.1f kg",
                    d.type().getTypeName(), d.type().getMaxLoad()));
        }
    }
}
