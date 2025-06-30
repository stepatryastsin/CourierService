package org.example.entity.couriers.couriervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.CourierData;

import java.util.List;

public class CourierValidator {
    private final List<Constraint<CourierData>> constraints = List.of(
            new NameConstraint(),
            new SpeedConstraint(),
            new LoadConstraint(),
            new WorkTimeConstraint(),
            new LocationConstraint()
    );
    public void validate(CourierData data) {
        for (var c : constraints) {
            c.check(data);
        }
    }
}
