package org.example.entity.order;

import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.entity.validate.OrderData;
import org.example.utils.GenerateID;

public class OrderFactory {
    private final GenerateID generateID = new GenerateID();
    private final OrderValidator validator = new OrderValidator();

    public Order create(Point start,
                        Point finish,
                        Time time,
                        double weight,
                        OrderType type) {
        int id = generateID.getId();
        OrderData data = new OrderData(id, start, finish, time, weight, type);
        validator.validate(data);
        return new Order(id, start, finish, time, weight, type, validator);
    }

}
