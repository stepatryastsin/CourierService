package org.example.courier;

import org.example.person.Person;

public class CourierCar extends Person {
    private int id;
    private String name;
    private double speed;
    private double energy;
    private boolean free;

    public CourierCar() {
        super();
    }

    public CourierCar(int id, String name,double speed,double energy) {
        super(id, name,speed,energy);
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
    public String toString() {
        return "CourierCar{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", speed=" + getSpeed() +
                ", energy=" + getEnergy() +
                ", free=" + getIsFree() +
                '}';
    }
}
