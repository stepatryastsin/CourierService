package org.example.utils;

import org.example.entity.couriers.Courier;
import org.example.entity.order.Order;
import org.example.entity.utils.Point;

import java.time.Duration;
import java.util.Random;

public class Utils {


    /**
     * Евклидово расстояние между двумя точками в метрах.
     */
    public static double getDistance(Point p1, Point p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.hypot(dx, dy);
    }

    /**
     * Полный путь курьера по заказу:
     * от текущей позиции до пикапа + от пикапа до доставки.
     */
    public static double getDistance(Courier courier, Order order) {
        Point start    = courier.getLocation();
        Point pickup   = order.getStart();
        Point delivery = order.getFinish();
        return getDistance(start, pickup)
                + getDistance(pickup, delivery);
    }

    /**
     * Время в пути (Duration) для курьера и заказа,
     * исходя из его скорости (м/с) и euclidean distance.
     */
    public static Duration getDuration(Courier courier, Order order) {
        double distance = getDistance(courier, order);
        double speed    = courier.getSpeed(); // в м/с
        long seconds    = (long)(distance / speed);
        return Duration.ofSeconds(seconds);
    }

    /**
     * Просто синоним getDuration экземляра по точкам:
     * время из Point from в Point to при заданной скорости.
     */
    public static Duration getTime(Point from, Point to, double speed) {
        double distance = getDistance(from, to);
        long seconds    = (long)(distance / speed);
        return Duration.ofSeconds(seconds);
    }

    /**
     * Клиентская стоимость: базовая + зависимость от дистанции и веса.
     */
    public static double moneySum(Courier courier, Order order) {
        double distance = getDistance(courier, order);
        // пример: 1.07 руб за метр и 0.75 руб за кг, +200 руб фикс
        return distance * 1.07 * (order.getWeight() * 0.75) + 200;
    }

    /**
     * Случайное число в [min, max).
     */
    public static int getRandomNumberUsingNextInt(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
