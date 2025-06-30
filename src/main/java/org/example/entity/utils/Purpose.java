package org.example.entity.utils;

import org.example.entity.couriers.Courier;
import org.example.entity.order.Order;
import org.example.utils.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Purpose {
    private final Courier courier;
    private final Order order;
    private final Point startPoint;
    private final Point endPoint;
    private final double routeLength;
    private final long timeExecution;
    private final double income;
    private final Time timeExecutionTime;
    private boolean isDone = false;

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");

    public Purpose(Courier courier, Order order) {
        if (courier == null) throw new IllegalArgumentException("courier must not be null");
        if (order   == null) throw new IllegalArgumentException("order must not be null");

        this.courier      = courier;
        this.order        = order;
        this.startPoint   = courier.getLocation();
        this.endPoint     = order.getFinish();
        this.routeLength  = Utils.getDistance(courier, order);
        this.timeExecution= Utils.getTime(courier, order);
        this.income       = Utils.moneySum(courier, order);

        LocalDateTime shiftStart = courier.getWorkStart();
        LocalDateTime shiftEnd   = courier.getWorkEnd();

        LocalDateTime orderWindowStart = order.getTime().getStart();
        LocalDateTime orderWindowEnd   = order.getTime().getEnd();

        LocalDateTime actualStart = orderWindowStart.isAfter(shiftStart)
                ? orderWindowStart
                : shiftStart;

        LocalDateTime projectedEnd = actualStart.plusSeconds(this.timeExecution);
        LocalDateTime actualEnd = projectedEnd.isAfter(shiftEnd)
                ? shiftEnd
                : projectedEnd;

        String startStr = actualStart.format(FMT);
        String endStr   = actualEnd  .format(FMT);
        this.timeExecutionTime = new Time(startStr, endStr);

        Utils.swapLocation(courier, order);

        this.isDone = true;
    }

    public Courier getCourier() {
        return courier;
    }

    public Order getOrder() {
        return order;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public double getRouteLength() {
        return routeLength;
    }

    public long getTimeExecution() {
        return timeExecution;
    }

    public double getIncome() {
        return income;
    }

    public Time getTimeExecutionTime() {
        return timeExecutionTime;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return String.format(
                "Purpose{courier=%d, order=%d, startTime=%s, endTime=%s, duration=%d sec, distance=%.0f m, income=%.0f₽}",
                courier.getId(),
                order.getId(),
                timeExecutionTime.getStart().format(FMT),
                timeExecutionTime.getEnd().format(FMT),
                timeExecution,
                routeLength,
                income
        );
    }
}