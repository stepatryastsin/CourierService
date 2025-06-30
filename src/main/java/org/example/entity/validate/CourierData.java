package org.example.entity.validate;

import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.entity.couriers.CourierType;

public record CourierData(
        int         id,
        String      name,
        CourierType type,
        double      speed,
        double      loadCapacity,
        Time workInterval,
        Point location
) { }
