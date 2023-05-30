package org.example.dividingTheQueue;

import org.example.abstractOrder.Order;
import org.example.abstractPerson.Person;
import org.example.basicAlgorithm.BasicAlgorithm;
import org.example.point.Point;
import org.example.schedule.Schedule;
import org.example.time.Time;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


class FirstPurposeTest {

    @Test
    void firstPurpose() throws ParseException {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, new Point(14.0, 14.0), new Point(14.00, 14.00), new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(2, new Point(18.0, 14.0), new Point(14.00, 14.05), new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(3, new Point(14.0, 14.0), new Point(14.00,14.00),new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(4, new Point(14.0, 14.0), new Point(14.00, 14.00), new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(5, new Point(14.0, 14.3), new Point(14.00,14.00),new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(6, new Point(14.0, 14.0), new Point(14.00,14.00), new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(7, new Point(14.0, 14.0), new Point(14.00, 14.00), new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(8, new Point(14.0, 14.0), new Point(14.00,14.00),new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(9, new Point(14.0, 14.0), new Point(14.00,14.00), new Time("08:00", "12:00"), 10.0));
        orders.add(new Order(10, new Point(14.00,14.00), new Point(14.00,14.00), new Time("08:00", "12:00"), 10.0));

        List<Person> persons = new ArrayList();
        persons.add(new Person(1, "Stepan", 2.0, 10.0,"08:00","12:00",new Point(2.0, 2.0)));
        persons.add(new Person(2, "Vadim", 1.0, 5.0,"08:00", "12:00",new Point(3.0, 3.0)));
        persons.add(new Person(3, "Misha", 3.0, 4.0,"08:00", "12:00",new Point(4.0, 4.0)));

        Schedule schedule = BasicAlgorithm.basicAlgorithm(persons, orders);
        schedule.beautifulString();

    }
}