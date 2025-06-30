package org.example.entity.order.ordervalidate;

import org.example.entity.validate.Constraint;
import org.example.entity.validate.OrderData;

public class WeightConstraint implements Constraint<OrderData> {
    @Override
    public void check(OrderData data) {
        double w = data.weight();
        if (w <= 0)
            throw new IllegalArgumentException("weight must be positive");
        if (w > data.type().getMaxWeight()) {
            throw new IllegalArgumentException(String.format(
                    "For %s order weight must be ≤ %.2f kg (was %.2f)",
                    data.type().name(), data.type().getMaxWeight(), w));
        }
    }
}
