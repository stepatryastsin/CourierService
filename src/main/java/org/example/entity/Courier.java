package org.example.entity;

import org.example.schedule.Schedule;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Courier {
    private final int        id;
    private final String     name;
    private final Vehicle    vehicle;
    private final double     speed;
    private final double     loadCapacity;
    private final Time       workInterval;
    private Point    location;
    private boolean  free;
    private Schedule schedule;

    public Courier(int id,
                   String name,
                   Vehicle vehicle,
                   double speed,
                   double loadCapacity,
                   String workStartStr,
                   String workEndStr,
                   Point location) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name must not be empty");
        Objects.requireNonNull(vehicle, "Vehicle must not be null");

        if (speed <= 0 || speed > vehicle.getMaxSpeed())
            throw new IllegalArgumentException(
                    String.format("Speed for %s must be >0 and ≤%.1f m/s",
                            vehicle.getTypeName(), vehicle.getMaxSpeed()));
        if (loadCapacity <= 0 || loadCapacity > vehicle.getMaxLoad())
            throw new IllegalArgumentException(
                    String.format("Load for %s must be >0 and ≤%.1f kg",
                            vehicle.getTypeName(), vehicle.getMaxLoad()));

        Objects.requireNonNull(workStartStr, "Work start must not be null");
        Objects.requireNonNull(workEndStr,   "Work end must not be null");
        this.workInterval = new Time(workStartStr, workEndStr);

        Objects.requireNonNull(location, "Location must not be null");

        this.id           = id;
        this.name         = name;
        this.vehicle      = vehicle;
        this.speed        = speed;
        this.loadCapacity = loadCapacity;
        this.location     = location;
        this.free         = true;
        this.schedule     = new Schedule();
    }

    public int getId()              { return id; }
    public String getName()         { return name; }
    public Vehicle getVehicle()     { return vehicle; }
    public double getSpeed()        { return speed; }
    public double getLoadCapacity() { return loadCapacity; }


    public LocalDateTime getWorkStart() {
        return workInterval.getStart();
    }
    public LocalDateTime getWorkEnd() {
        return workInterval.getEnd();
    }

    public Point getLocation()      { return location; }
    public boolean isFree()         { return free; }
    public Schedule getSchedule()   { return schedule; }

    public void setLocation(Point location) {
        this.location = Objects.requireNonNull(location, "Location must not be null");
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = Objects.requireNonNull(schedule, "Schedule must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;
        return id == ((Courier) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
                "Courier{id=%d, name='%s', via=%s, speed=%.2f, load=%.2f, work=[%s–%s], loc=%s, free=%b}",
                id,
                name,
                vehicle.getTypeName(),
                speed,
                loadCapacity,
                workInterval.getStart().format(Time.FMT),
                workInterval.getEnd()  .format(Time.FMT),
                location,
                free
        );
    }
}