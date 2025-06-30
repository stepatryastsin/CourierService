package org.example.entity.couriers;
import org.example.entity.utils.Point;
import org.example.entity.utils.Time;

public final class RandomCourier {
    private static final CourierFactory factory = new CourierFactory();

    private RandomCourier() {  }

    public static Courier getRandomCourier() {
        String name         = RandomValueCourier.getName();
        var type    = RandomValueCourier.getRandomType();
        double speed        = RandomValueCourier.getSpeed(type);
        double capacity     = RandomValueCourier.getCapacity(type);
        var location      = RandomValueCourier.getRandomPoint();
        var workInterval   = RandomValueCourier.getRandomWorkTime();

        return factory.create(
                name,
                type,
                speed,
                capacity,
                workInterval,
                location
        );
    }
}