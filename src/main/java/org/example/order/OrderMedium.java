package org.example.order;

import org.example.abstractOrder.Order;
import org.example.point.Point;
import org.example.time.Time;
/**
 * Средний заказ,ограничения по {@link OrderMedium#weight} не > 5, наследник {@link Order}
 */
public class OrderMedium extends Order {

    private int id;
    private Point pointStart;
    private Point pointFinish;
    private Time time;
    private double weight;

    public OrderMedium() {
        super();
    }

    public OrderMedium(int id, Point pointStart, Point pointFinish, Time time, double weight) {
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

        return "id=" + id +
                ", Type=Medium" +
                ", pointStart=" + pointStart +
                ", pointFinish=" + pointFinish +
                ", time=" + time +
                ", weight=" + weight +
                '}';
    }
}