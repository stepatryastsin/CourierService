package org.example.courier;

import org.example.abstractPerson.Person;
import org.example.point.Point;
/**
 * Курьер на мотоцикле,ограничения по {@link CourierBike#speed} не быстрее 6 м/с (20 км/ч),ограничения по {@link CourierBike#energy} не больше 5 кг, наследник {@link Person}
 */
public class CourierBike  extends Person{
    private int id;
    private String name;
    private double speed;
    private double energy;
    private boolean free;
    private Point location;


    public CourierBike() {
        super();
    }

    public CourierBike(int id, String name,double speed,double energy,String startTimeInterval,String timeEndCourier, Point location) {
        super(id, name,speed,energy,startTimeInterval,timeEndCourier,location);
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point location) {
        this.location = location;
    }

    public void setIsFree(boolean free) {
        this. free = free;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Type=By bike" +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", energy=" + energy +
                ", location=" + location +
                '}';
    }
}
