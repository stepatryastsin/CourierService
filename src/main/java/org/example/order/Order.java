package org.example.order;

import org.example.point.Point;
import org.example.time.Time;

// TODO: 08/04/2023
public class Order {
    private int id;
    private Point pointStart;
    private Point pointFinish;
    //private double distance;
    private Time timeStart;
    private Time timeFinish;
    private EnumOrder weight;

    public Order() {}

    public Order(int id, Point pointStart, Point pointFinish, Time timeStart, Time timeFinish, EnumOrder weight) {
        this.id = id;
        this.pointStart = pointStart;
        this.pointFinish = pointFinish;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPointStart() {
        return pointStart;
    }

    public void setPointStart(Point pointStart) {
        this.pointStart = pointStart;
    }

    public Point getPointFinish() {
        return pointFinish;
    }

    public void setPointFinish(Point pointFinish) {
        this.pointFinish = pointFinish;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(Time timeFinish) {
        this.timeFinish = timeFinish;
    }

    public EnumOrder getWeight() {
        return weight;
    }

    public void setWeight(EnumOrder weight) {
        this.weight = weight;
    }
}
