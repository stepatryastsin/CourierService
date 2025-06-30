package org.example.entity.order.ordervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.OrderData;

public class RouteConstraint implements Constraint<OrderData> {
    @Override
    public void check(OrderData data) {
        if (data.start() == null)
            throw new IllegalArgumentException("start must not be null");
        if (data.finish() == null)
            throw new IllegalArgumentException("finish must not be null");
        if (data.start().equals(data.finish()))
            throw new IllegalArgumentException("finish must differ from start");
    }
}
