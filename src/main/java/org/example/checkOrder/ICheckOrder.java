package org.example.checkOrder;

import org.example.abstractOrder.Order;
/**
 * Интерфейс реализует контракт с заказом(маленький, средний, большой) ,
 * позволяет проверить ввод данных на корректность и исключить невозможные случаии.
 * Происходит проверка  на вес заказа
 */
public interface ICheckOrder {
    boolean checkOrderLight (Order order) throws Exception;
    boolean checkOrderMedium (Order order) throws Exception;
    boolean checkOrderHard (Order order) throws Exception;
}
