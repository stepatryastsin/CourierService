package org.example.checkOrder;

import org.example.abstractOrder.Order;

public class CheckOrder implements ICheckOrder{
    /**
     * Малый заказ {@link org.example.order.OrderLight}
     * Может иметь вес > 0 но < 3 (кг)
     */
    @Override
    public boolean checkOrderLight(Order order) throws Exception {
        if (order.getWeight()>0.0 && order.getWeight()<=3.0) {
            return true;
        }
        return false;
    }
    /**
     * Средний заказ {@link org.example.order.OrderMedium}
     * Может иметь вес > 0 но < 5 (кг)
     */
    @Override
    public boolean checkOrderMedium(Order order) throws Exception {
        if (order.getWeight()>0.0 && order.getWeight()<=5.0) {
            return true;
        }
        return false;
    }
    /**
     * Большой заказ {@link org.example.order.OrderHard}
     * Может иметь вес > 0 но < 10 (кг)
     */
    @Override
    public boolean checkOrderHard(Order order) throws Exception {
        if (order.getWeight()>0.0 && order.getWeight()<=10.0) {
            return true;
        }
        return false;
    }
}
