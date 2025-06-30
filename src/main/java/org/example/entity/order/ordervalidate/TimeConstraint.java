package org.example.entity.order.ordervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.OrderData;

public class TimeConstraint implements Constraint<OrderData> {
    @Override
    public void check(OrderData data) {
        if (data.time() == null)
            throw new IllegalArgumentException("time must not be null");
        if (data.time().getEnd().isBefore(data.time().getStart()))
            throw new IllegalArgumentException("End time must be after or equal to start time");
    }
}
