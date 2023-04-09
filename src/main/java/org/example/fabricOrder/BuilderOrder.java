package org.example.fabricOrder;

import org.example.order.EnumOrder;
import org.example.order.Order;
import org.example.point.Point;
import org.example.time.Time;

public class BuilderOrder {
    Order order;

    public BuilderOrder(EnumOrder type) throws Exception {
        order = new Factory().getNewOrder(type);
    }

    public BuilderOrder id (int id) {
        order.setId(id);
        return this;
    }

    public BuilderOrder pointStart (Point pointStart) {
        order.setPointStart(pointStart);
        return this;
    }

    public BuilderOrder pointFinish (Point pointFinish) {
        order.setPointFinish(pointFinish);
        return this;
    }

    public BuilderOrder timeStart (Time timeStart) {
        order.setTimeStart(timeStart);
        return this;
    }

    public BuilderOrder timeFinish (Time timeFinish) {
        order.setTimeFinish(timeFinish);
        return this;
    }

    public Order build() {
        return order;
    }
    //public BuilderOrder

    private class Factory {
        Order getNewOrder(EnumOrder enumOrder) throws Exception {
            Order order = null;

            switch (enumOrder) {
                case LIGHT:
                    order.setWeight(EnumOrder.LIGHT);
                    break;
                case MEDIUM:
                    order.setWeight(EnumOrder.MEDIUM);
                    break;
                case HARD:
                    order.setWeight(EnumOrder.HARD);
                    break;
                default:
                    throw new Exception("Invalid order type!");
            }
            return order;
        }
    }
}