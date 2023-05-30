package org.example.order;

import org.example.abstractOrder.Order;
import org.example.point.Point;
import org.example.time.Time;
/**
 * Малый заказ,ограничения по {@link OrderLight#weight} не > 3, наследник {@link Order}
 */
public class OrderLight extends Order {

    private int id;
    private Point pointStart;
    private Point pointFinish;
    private Time time;
    private double weight;

    public OrderLight() {super();}

    public OrderLight(int id, Point pointStart, Point pointFinish, Time time, double weight) {
        super(id, pointStart, pointFinish, time, weight);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Point getPointStart() {
        return pointStart;
    }

    @Override
    public void setPointStart(Point pointStart) {
        this.pointStart = pointStart;
    }

    @Override
    public Point getPointFinish() {
        return pointFinish;
    }

    @Override
    public void setPointFinish(Point pointFinish) {
        this.pointFinish = pointFinish;
    }



    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Time getTime() {
        return time;
    }

    @Override
    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return
                "id=" + this.id +
                ", Type=Light" +
                ", pointStart=" + this.pointStart +
                ", pointFinish=" + this.pointFinish +
                ", time=" + this.time +
                ", weight=" + getWeight() +
                '}';
    }

}
