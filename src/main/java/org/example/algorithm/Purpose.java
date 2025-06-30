package org.example.algorithm;

import org.example.entity.couriers.Courier;
import org.example.entity.order.Order;
import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.utils.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Purpose {
    private static final int PICKUP_TIME_SEC   = 5 * 60;   // 5 минут
    private static final int DELIVERY_TIME_SEC = 5 * 60;   // 5 минут

    private final Courier courier;
    private final Order order;
    private final Point startPoint;
    private final Point endPoint;
    private final double routeDistance;       // в метрах
    private final long totalTimeSeconds;      // в секундах (движение+погрузка+разгрузка)
    private final double income;
    private final Time timeWindow;            // реальное окно выполнения
    private final boolean feasible;

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");

    private Purpose(Courier courier,
                    Order order,
                    Point startPoint,
                    Point endPoint,
                    double routeDistance,
                    long totalTimeSeconds,
                    double income,
                    Time timeWindow) {
        this.courier          = courier;
        this.order            = order;
        this.startPoint       = startPoint;
        this.endPoint         = endPoint;
        this.routeDistance    = routeDistance;
        this.totalTimeSeconds = totalTimeSeconds;
        this.income           = income;
        this.timeWindow       = timeWindow;
        this.feasible         = true;
    }

    public boolean   isFeasible()          { return feasible; }
    public double    getIncome()           { return income; }
    public double    getTotalMinutes()     { return totalTimeSeconds / 60.0; }
    public long      getTotalTimeSeconds() { return totalTimeSeconds; }
    public Point     getEndPoint()         { return endPoint; }
    public Time      getTimeWindow()       { return timeWindow; }

    public Courier getCourier() {
        return courier;
    }

    public Order getOrder() {
        return order;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public double getRouteDistance() {
        return routeDistance;
    }

    public static Purpose createIfFeasible(Courier courier, State state, Order order) {
        if (order.getWeight() > courier.getType().getMaxLoad()) {
            return null;
        }

        LocalDateTime now      = state.now();
        LocalDateTime shiftEnd = state.shiftEnd();
        double speed           = courier.getType().getMaxSpeed();  // м/с

        // 1) время до пикапа
        Duration t1 = Utils.getTime(state.getLocation(), order.getStart(), speed);
        LocalDateTime arrivePickup = now.plus(t1);
        if (arrivePickup.isAfter(order.getTime().getEnd())) return null;

        // 2) погрузка
        LocalDateTime startPickup = arrivePickup.isBefore(order.getTime().getStart())
                ? order.getTime().getStart()
                : arrivePickup;
        LocalDateTime endPickup = startPickup.plusSeconds(PICKUP_TIME_SEC);

        Duration t2 = Utils.getTime(order.getStart(), order.getFinish(), speed);
        LocalDateTime arriveDelivery = endPickup.plus(t2);
        if (arriveDelivery.isAfter(shiftEnd)) return null;

        LocalDateTime windowStart = startPickup;
        LocalDateTime windowEnd   = arriveDelivery.plusSeconds(DELIVERY_TIME_SEC);
        Time timeWindow = new Time(
                windowStart.format(FMT),
                windowEnd  .format(FMT)
        );

        double d1 = Utils.getDistance(state.getLocation(), order.getStart());
        double d2 = Utils.getDistance(order.getStart(), order.getFinish());
        double totalDistance = d1 + d2;

        long totalSec = t1.getSeconds()
                + PICKUP_TIME_SEC
                + t2.getSeconds()
                + DELIVERY_TIME_SEC;

        double income = Utils.moneySum(courier, order);

        return new Purpose(
                courier,
                order,
                state.getLocation(),
                order.getFinish(),
                totalDistance,
                totalSec,
                income,
                timeWindow
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Purpose{courier=%d, order=%d, window=%s–%s, duration=%d sec, dist=%.0f m, inc=%.0f₽}",
                courier.getId(),
                order.getId(),
                timeWindow.getStart(),
                timeWindow.getEnd(),
                totalTimeSeconds,
                routeDistance,
                income
        );
    }
}