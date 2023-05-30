package org.example.courier;

import org.example.abstractPerson.Person;
import org.example.point.Point;
/**
 * Курьер пеший,ограничения по {@link CourierPeople#speed} не быстрее 2.8 м/с (10 км/ч),ограничения по {@link CourierPeople#energy} не больше 3 кг, наследник {@link Person}
 */
public class CourierPeople extends Person {
    private int id;
    private String name;
    private double speed;
    private double energy;
    private boolean free;
    private Point location;

    public CourierPeople(int id,String name,double speed,double energy,String timeStartInterval,String timeEndCourier,Point location) {
        super(id,name,speed,energy,timeStartInterval,timeEndCourier,location);
    }

    public CourierPeople() {
        super();
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

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isFree() {
        return free;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Type=By foot" +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", energy=" + energy +
                ", location=" + location +
                '}';
    }

}
