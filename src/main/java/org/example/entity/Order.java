package org.example.entity;

import java.util.Objects;


public class Order {

    private final int id;
    private final Point start;
    private final Point finish;
    private final Time time;
    private final double weight;
    private final EnumOrder type;

    public Order(int id,
                 Point start,
                 Point finish,
                 Time time,
                 double weight,
                 EnumOrder type) {
        if (start == null) throw new IllegalArgumentException("start must not be null");
        if (finish == null) throw new IllegalArgumentException("finish must not be null");
        if (finish.equals(start)) throw new IllegalArgumentException("finish must differ from start");
        if (time == null) throw new IllegalArgumentException("time must not be null");
        if (time.getEnd().isBefore(time.getStart()))
            throw new IllegalArgumentException("End time must be after or equal to start time");
        if (type == null) throw new IllegalArgumentException("type must not be null");
        if (weight <= 0)
            throw new IllegalArgumentException("weight must be positive");
        if (weight > type.getMaxWeight()) {
            throw new IllegalArgumentException(String.format(
                    "For %s order weight must be ≤ %.2f kg (was %.2f)",
                    type, type.getMaxWeight(), weight));
        }

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

    public EnumOrder getType() {
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

