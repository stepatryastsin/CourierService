package org.example.entity.order;

import java.util.Map;

public class OrderTypeFactory {
    private static final Map<String, OrderType> TYPES = Map.of(
            LightOrderType.NAME, new LightOrderType(),
            MediumOrderType.NAME, new MediumOrderType(),
            HeavyOrderType.NAME, new HeavyOrderType()
    );
    public static OrderType getByName(String name){
        OrderType type = TYPES.get(name);
        if (type == null) {
            throw new IllegalArgumentException("Unknown order type: " + name);
        }
        return type;
    }
}
