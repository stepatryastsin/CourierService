package org.example.courier;

import org.example.abstractPerson.Person;
import org.example.point.Point;
/**
 * Курьер на машине,ограничения по {@link CourierCar#speed} не быстрее 16 м/с (60 км/ч),ограничения по {@link CourierCar#energy} не больше 10 кг, наследник {@link Person}
 */
public class CourierCar extends Person {
    private int id;
    private String name;
    private double speed;
    private double energy;
    private Point location;

    public CourierCar() {
        super();
    }

    public CourierCar(int id, String name,double speed,double energy,String timeStartInterval,String timeEndCourier,Point location) {
        super(id, name,speed,energy,timeStartInterval,timeEndCourier, location);
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

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Type=By car" +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", energy=" + energy +
                ", location=" + location +
                '}';
    }
}
