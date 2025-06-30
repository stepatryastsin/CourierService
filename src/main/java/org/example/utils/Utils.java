package org.example.utils;

import org.example.entity.couriers.Courier;
import org.example.entity.order.Order;

import java.util.Random;

public class Utils {

    public static void swapLocation (Courier courier, Order order) {
        courier.setLocation(order.getFinish());
    }
    public static float getDistance(Courier person, Order order) {
        float distToWarehouse = person.getLocation().distanceTo(order.getStart());
        float distToClient = order.getStart().distanceTo(order.getFinish());
        return distToWarehouse+distToClient;
    }
    public static long getTime(Courier person, Order order){
        return (long) (getDistance(person,order) / person.getSpeed());
    }
    public static double moneySum(Courier courier, Order order) {
        double distance = Utils.getDistance(courier,order);
        return distance * 1.07 * (order.getWeight() * 0.75) + 200;
    }
    public static int getRandomNumberUsingNextInt(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
