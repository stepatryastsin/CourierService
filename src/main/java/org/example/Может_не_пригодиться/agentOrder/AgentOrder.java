package org.example.Может_не_пригодиться.agentOrder;

import org.example.entity.Order;
import org.example.entity.Point;
import org.example.entity.Time;

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