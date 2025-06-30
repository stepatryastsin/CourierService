package org.example.entity.order;

import org.example.entity.order.ordervalidate.RouteConstraint;
import org.example.entity.order.ordervalidate.TimeConstraint;
import org.example.entity.order.ordervalidate.TypeConstraint;
import org.example.entity.order.ordervalidate.WeightConstraint;
import org.example.entity.validate.Constraint;
import org.example.entity.validate.OrderData;

import java.util.List;

public class OrderValidator {
    private final List<Constraint<OrderData>> constraints = List.of(
            new RouteConstraint(),
            new TimeConstraint(),
            new TypeConstraint(),
            new WeightConstraint()
    );

    public void validate(OrderData data) {
        for (var c : constraints) {
            c.check(data);
        }
    }
}
