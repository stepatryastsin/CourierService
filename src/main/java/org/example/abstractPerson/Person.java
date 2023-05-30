package org.example.abstractPerson;

import org.example.abstractOrder.Order;
import org.example.checkOrder.CheckOrder;
import org.example.checkOrder.ICheckOrder;
import org.example.point.Point;
import org.example.schedule.Schedule;

import java.util.Objects;

/**
 * Фундаментальный класс person,основные характерестики:
 * id-уникальный номер,name - Имя курьера, Speed - скорость курьера(м\с),
 * energy - максимальная грузоподъемность курьера(кг), location - местоположение курьера(м),
 * schedule - рассписание курьера
 * Класс {@link Person} является родительским для трех его потомков:
 *{@link org.example.courier.CourierBike} , {@link org.example.courier.CourierCar},
 *{@link org.example.courier.CourierPeople}
 */
public  class Person {

    private int id;//уникальный номер
    private String name;//Имя
    private String timeStartCourier;
    private String timeEndCourier;
    private double speed;//Скорость
    private double energy;//Грузоподъёмность
    private Point location;//Местоположение
    private boolean setIsFree;
    private Schedule schedule;//Рассписание


    public boolean getIsFree() {
        return setIsFree;
    }
    public void setSetIsFree(boolean setIsFree) {
        this.setIsFree = setIsFree;
    }
    // setIsFree why?

    public Person() {}

    public Person(int id, String name, double speed, double energy,String timeStartCourier,String timeEndCourier, Point location) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.energy = energy;
        this.location = location;
        this.timeStartCourier = timeStartCourier;
        this.timeEndCourier = timeEndCourier;
        this.schedule = new Schedule();
    }

    public String getTimeStartCourier() {
        return timeStartCourier;
    }

    public void setTimeStartCourier(String timeStartCourier) {
        this.timeStartCourier = timeStartCourier;
    }

    public String getTimeEndCourier() {
        return timeEndCourier;
    }

    public void setTimeEndCourier(String timeEndCourier) {
        this.timeEndCourier = timeEndCourier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    @Override
    public String toString() {

        return
                "id=" + id +
                ", Type=Blank" +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", energy=" + energy +
                ", location=" + location +
                '}';
    }


}


