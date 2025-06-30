package org.example.entity.order.ordervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.OrderData;

public class TypeConstraint implements Constraint<OrderData> {
    @Override
    public void check(OrderData data) {
        if (data.type() == null)
            throw new IllegalArgumentException("type must not be null");
    }
}
