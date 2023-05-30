package org.example.fabricOrder;

import org.example.checkOrder.CheckOrder;
import org.example.enumType.EnumOrder;
import org.example.abstractOrder.Order;
import org.example.order.OrderHard;
import org.example.order.OrderLight;
import org.example.order.OrderMedium;
import org.example.point.Point;
import org.example.time.Time;
/**
 * Реализация шаблона фабрики и билдера для создания заказа по индивидуальным параметрам
 */
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
    public BuilderOrder weight (double weight) {
        order.setWeight(weight);
        return this;
    }
    public BuilderOrder time (Time time) {
        order.setTime(time);
        return this;
    }


    public Order build() {
        return order;
    }
    //public BuilderOrder

    private class Factory {
        Order getNewOrder(EnumOrder enumOrder) throws Exception {
            Order order = null;
            CheckOrder checkOrder = new CheckOrder();
            switch (enumOrder) {
                case LIGHT:
                    order = new OrderLight();
                    if (checkOrder.checkOrderLight(order)) throw new Exception("Не коректные данные!");
                    break;
                case MEDIUM:
                    order = new OrderMedium();
                    if (checkOrder.checkOrderMedium(order)) throw new Exception("Не коректные данные!");
                    break;
                case HARD:
                    order = new OrderHard();
                    if (checkOrder.checkOrderHard(order)) throw new Exception("Не коректные данные!");
                    break;
                default:
                    throw new Exception("Не коректные данные!");
            }
            return order;
        }
    }
}