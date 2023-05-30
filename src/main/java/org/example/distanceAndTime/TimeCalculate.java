package org.example.distanceAndTime;

import org.example.abstractOrder.Order;
import org.example.abstractPerson.Person;
/**
 * Класс позволяет рассчитать время  {@link Person#getLocation()}, точкой сбора {@link Order#getPointStart()} и точкой доставки {@link Order#getPointFinish()}
 */
public class TimeCalculate {
    public static long getTime(Person person, Order order){
        return (long) (DistanceCalculate.getDistance(person,order)/person.getSpeed());
    }
}
