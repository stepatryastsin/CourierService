package org.example.entity.couriers.couriervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.CourierData;

public class WorkTimeConstraint implements Constraint<CourierData> {
    @Override public void check(CourierData d) {
        if (d.workInterval() == null)
            throw new IllegalArgumentException("Work interval must not be null");
        if (d.workInterval().getEnd().isBefore(d.workInterval().getStart()))
            throw new IllegalArgumentException("Work end must be after start");
    }
}
