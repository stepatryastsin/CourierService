package org.example.abstractOrder;
import org.example.checkOrder.CheckOrder;
import org.example.checkOrder.ICheckOrder;
import org.example.point.Point;
import org.example.time.Time;

// TODO: 08/04/2023
/**
 *  Фундаментальны класс, основные характеристики
 *
 *  id, {@link Point} начальная точка заказа (метры),
 *
 *   {@link Point} конечная точка заказа (метры),
 *
 *   {@link Time} время выполнения (формат "X:Y"), вес (кг).
 *
 *
 *  Класс {@link Order} является родительским для трех его потомков:
 *
 *  {@link org.example.order.OrderLight} , {@link org.example.order.OrderMedium},
 *
 *  {@link org.example.order.OrderHard}
 */
public class Order {
    private int id;//Уникальный номер заказа
    private Point pointStart;//Точка сбора
    private Point pointFinish;//Точка доставки
    private Time time;//Время
    private double weight;//Вес
    public boolean flag;

    public Order() {
    }

    public Order(int id, Point pointStart, Point pointFinish, Time time, double weight) {
        this.id = id;
        this.pointStart = pointStart;
        this.pointFinish = pointFinish;
        this.time = time;
        this.weight = weight;
        this.flag = false;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
//

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Type=Blank" +
                ", pointStart=" + pointStart +
                ", pointFinish=" + pointFinish +
                ", time=" + time +
                ", weight=" + weight +
                '}';
    }



}

