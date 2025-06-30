package org.example.entity.order;

import org.example.entity.utils.Time;

import java.time.LocalDateTime;

/**
 * Класс генерирует заказы {@link Order} с разными полями для стресс теста
 */
public class RandomOrder {
    public static Order getRandomOrder(){
        var start    = RandomValueOrder.getRandomPoint();
        var finish   = RandomValueOrder.getRandomPoint();
        LocalDateTime yearStart = LocalDateTime.of(2025, 1, 1, 0, 0);
        LocalDateTime yearEnd   = LocalDateTime.of(2025, 12, 31, 23, 59);
        var time     = Time.randomBetween(yearStart, yearEnd);
        org.example.entity.order.OrderType type = RandomValueOrder.randomType();
        double weight = RandomValueOrder.getRandomWeight(type);
        var factory = new OrderFactory();
        return factory.create(start, finish, time, weight, type);
    }
}

