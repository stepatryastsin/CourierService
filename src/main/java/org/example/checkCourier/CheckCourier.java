package org.example.checkCourier;

import org.example.abstractPerson.Person;
/**
 * Реализация интерфейса @Param person определяется за счет фабрики шаблон и общего класса Order
 */
public class CheckCourier implements ICheckCourier{
    /**
     * Курьер на машине {@link org.example.courier.CourierPeople}, Может иметь скорость > 0 м/с но <= 16 м/с (60 км/ч), Может иметь грузоподъемность > 0 кг но <= 10 кг
     */
    @Override
    public boolean checkCarCourier(Person person) throws Exception {
        if((person.getSpeed()>0.0&&person.getSpeed()<=16)&&(person.getEnergy()>0.0&&person.getEnergy()<=10.0)){
            return true;
        }
        return false;
    }
    /**
     * Курьер пеший {@link org.example.courier.CourierPeople}, Может иметь скорость > 0 м/с но <= 2.8 м/с (10 км/ч), Может иметь грузоподъемность > 0 кг но <= 3 кг
     */
    @Override
    public boolean checkPeopleCourier(Person person) throws Exception {
        if((person.getSpeed()>0.0&&person.getSpeed()<=2.8)&&(person.getEnergy()>0.0&&person.getEnergy()<=3.0)){
            return true;
        }
        return false;
    }
    /**
     * Курьер на велосипеде {@link org.example.courier.CourierBike}, Может иметь скорость > 0 м/с но <= 6 м/с (20 км/ч), Может иметь грузоподъемность > 0 кг но <= 5 кг,
     */
    @Override
    public boolean checkBikeCourier(Person person) throws Exception {
        if((person.getSpeed()>0.0&&person.getSpeed()<=6.0)&&(person.getEnergy()>0.0&&person.getEnergy()<=5.0)){
            return true;
        }
        return false;
    }
}
