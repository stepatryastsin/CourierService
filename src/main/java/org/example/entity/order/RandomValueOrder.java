package org.example.entity.order;

import org.example.entity.utils.Point;
import org.example.entity.utils.WorldConstants;
import org.example.utils.Utils;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomValueOrder {
    private static final Random random = new Random();
    private static final List<OrderType> TYPE_LIST = List.of(
            new LightOrderType(),
            new MediumOrderType(),
            new HeavyOrderType()
    );

    private RandomValueOrder() { }

    public static OrderType randomType() {
        int idx = ThreadLocalRandom.current().nextInt(TYPE_LIST.size());
        return TYPE_LIST.get(idx);
    }

    public static Point getRandomPoint() {
        float x = Utils.getRandomNumberUsingNextInt(random,
                (int) WorldConstants.MIN_X,
                (int) WorldConstants.MAX_X);
        float y = Utils.getRandomNumberUsingNextInt(random,
                (int) WorldConstants.MIN_Y,
                (int) WorldConstants.MAX_Y);
        return new Point(x, y);
    }

    public static double getRandomWeight(OrderType type) {
        double max = type.getMaxWeight();
        return ThreadLocalRandom.current().nextDouble(Double.MIN_VALUE, max);
    }
}
