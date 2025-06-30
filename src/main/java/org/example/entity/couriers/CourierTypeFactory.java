package org.example.entity.couriers;

import java.util.Map;

public class CourierTypeFactory {
    private static final Map<String, CourierType> TYPES = Map.of(
            PedestrianCourierType.NAME, new PedestrianCourierType(),
            BikeCourierType.NAME, new BikeCourierType(),
            CarCourierType.NAME, new CarCourierType()
    );

    public static CourierType getByName(String key) {
        CourierType type = TYPES.get(key);
        if (type == null) {
            throw new IllegalArgumentException("Unknown courier type: " + key);
        }
        return type;
    }
}
