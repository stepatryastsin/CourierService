package org.example.entity.order;
import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.entity.validate.OrderData;

import java.util.Objects;


public class Order {

    private final int id;
    private final Point start;
    private final Point finish;
    private final Time time;
    private final double weight;
    private final OrderType type;

    public Order(int id,
                 Point start,
                 Point finish,
                 Time time,
                 double weight,
                 OrderType type) {
        this.id     = id;
        this.start  = start;
        this.finish = finish;
        this.time   = time;
        this.weight = weight;
        this.type   = type;
    }

    public int getId() {
        return id;
    }

    public Point getStart() {
        return start;
    }

    public Point getFinish() {
        return finish;
    }

    public Time getTime() {
        return time;
    }

    public double getWeight() {
        return weight;
    }

    public OrderType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return id == order.id
                && Double.compare(order.weight, weight) == 0
                && start.equals(order.start)
                && finish.equals(order.finish)
                && time.equals(order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, finish, time, weight);
    }

    @Override
    public String toString() {
        return String.format(
                "Order{id=%d, type=%s, start=%s, finish=%s, time=%s, weight=%.2f}",
                id, type, start, finish, time, weight
        );
    }
}

