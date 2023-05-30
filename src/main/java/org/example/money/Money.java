package org.example.money;

import org.example.abstractOrder.Order;
import org.example.abstractPerson.Person;
import org.example.point.Point;
/**
 * Класс позволяет рассчита приносимую прибыль с заказа(до работать: с объяснением коэфицента)
 */
public class Money {
    private static double sum;

    public static double moneySum(Person pointCourier, Order order) {
        //firstDistance - расстояние от курьера до точки сбора заказа
        double firstDistance = Point.distanceFourPoint(pointCourier.getLocation().getX(), pointCourier.getLocation().getY(),
                order.getPointStart().getX(), order.getPointStart().getY());

        //secondDistance - расстояние от точка сбора до точки доставки заказа
        double secondDistance = Point.distanceFourPoint(order.getPointStart().getX(), order.getPointStart().getY(),
                order.getPointFinish().getX(), order.getPointFinish().getY());

        // расстояние * вес * "денежный коэфициент (с потолка)" + 200 за выполнение заказа.
        sum = (firstDistance * 1.1) + ((secondDistance * 1.5) * (order.getWeight() * 0.75)) + 200;

        return sum;
    }
}