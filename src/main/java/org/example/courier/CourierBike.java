package org.example.courier;

import org.example.person.Person;

public class CourierBike  extends Person{
    private int id;
    private String name;
    private double speed;
    private double energy;
    private boolean free;

    //Объясните, пожалуйста, вы забыли про поле free или так надо?

    public CourierBike() {
        super();
    }

    public CourierBike(int id, String name,double speed,double energy) {
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

    public void setIsFree(boolean free) {
        this. free = free;
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
