package org.example.entity.couriers;

import com.github.javafaker.Faker;
import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.entity.utils.WorldConstants;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomValueCourier {
    private static final Faker faker = new Faker();
    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();
    private static final LocalDateTime MIN_TIME = LocalDateTime.of(2025, Month.JANUARY, 1, 0, 0);
    private static final LocalDateTime MAX_TIME = LocalDateTime.of(2025, Month.DECEMBER, 31, 23, 59);
    private static final List<CourierType> TYPE_LIST = List.of(
            new PedestrianCourierType(),
            new CarCourierType(),
            new BikeCourierType());

    public static CourierType randomType(){
        int idx = ThreadLocalRandom.current().nextInt(TYPE_LIST.size());
        return TYPE_LIST.get(idx);
    }
    private RandomValueCourier() { }

    public static String getName() {
        return faker.name().fullName();
    }

    public static CourierType getRandomType() {
        int idx = ThreadLocalRandom.current().nextInt(TYPE_LIST.size());
        return TYPE_LIST.get(idx);
    }

    public static double getSpeed(CourierType type) {
        return rnd.nextDouble(Double.MIN_VALUE, type.getMaxSpeed());
    }

    public static double getCapacity(CourierType type) {
        return rnd.nextDouble(Double.MIN_VALUE, type.getMaxLoad());
    }

    public static Point getRandomPoint() {
        float x = rnd.nextFloat() * (WorldConstants.MAX_X - WorldConstants.MIN_X) + WorldConstants.MIN_X;
        float y = rnd.nextFloat() * (WorldConstants.MAX_Y - WorldConstants.MIN_Y) + WorldConstants.MIN_Y;
        return new Point(x, y);
    }

    public static Time getRandomWorkTime() {
        return Time.randomBetween(MIN_TIME, MAX_TIME);
    }
}