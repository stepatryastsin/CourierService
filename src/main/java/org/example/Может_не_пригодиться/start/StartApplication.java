package org.example.Может_не_пригодиться.start;

import org.example.entity.Order;
import org.example.entity.Person;

import java.util.List;

public class StartApplication {
    List<Person> allPeople;
    List<Order> allOrder;

    public StartApplication(List<Person> allPeople, List<Order> allOrder) {
        this.allPeople = allPeople;
        this.allOrder = allOrder;
    }

    public void startOfWork() {

    }

}
