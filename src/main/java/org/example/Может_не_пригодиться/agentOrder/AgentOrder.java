package org.example.Может_не_пригодиться.agentOrder;

import org.example.abstractOrder.Order;
import org.example.point.Point;
import org.example.time.Time;

public class AgentOrder extends Order {
    private int id;
    private Point pointStart;
    private Point pointFinish;
    //private double distance;
    private Time timeStart;
    private Time timeFinish;
    private double weight;

    public AgentOrder() {}

}