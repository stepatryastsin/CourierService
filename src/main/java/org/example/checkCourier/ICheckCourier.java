package org.example.checkCourier;

import org.example.abstractPerson.Person;
/**
 * Интерфейс реализует контракт с курьерами(пеший,на машине,на велосипеде) ,
 * позволяет проверить ввод данных на корректность и исключить невозможные случаии.
 * Происходит проверка возможной скорости курьера и его грузоподъемности
 */
public interface ICheckCourier {
    boolean  checkCarCourier(Person person) throws Exception;
    boolean checkPeopleCourier(Person person) throws Exception;
    boolean checkBikeCourier(Person person) throws Exception;
}
