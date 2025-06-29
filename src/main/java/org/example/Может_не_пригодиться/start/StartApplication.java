package org.example.Может_не_пригодиться.start;

import org.example.entity.Courier;
import org.example.entity.Order;


import java.util.List;

public class StartApplication {
    List<Courier> allPeople;
    List<Order> allOrder;

    public StartApplication(List<Courier> allPeople, List<Order> allOrder) {
        this.allPeople = allPeople;
        this.allOrder = allOrder;
    }

    public void startOfWork() {

    }

}
