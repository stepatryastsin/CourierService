package org.example.entity.couriers;

import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.entity.validate.CourierData;
import org.example.entity.couriers.couriervalidate.CourierValidator;
import org.example.entity.Schedule;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Courier {
    private final int          id;
    private final String       name;
    private final CourierType  type;
    private final double       speed;
    private final double       loadCapacity;
    private final Time         workInterval;
    private       Point        location;
    private       boolean      free;
    private       Schedule     schedule;

    public Courier(int id,
                   String name,
                   CourierType type,
                   double speed,
                   double loadCapacity,
                   Time workInterval,
                   Point location,
                   CourierValidator validator) {
        var data = new CourierData(id, name, type, speed, loadCapacity, workInterval, location);
        validator.validate(data);

        this.id           = id;
        this.name         = name;
        this.type         = type;
        this.speed        = speed;
        this.loadCapacity = loadCapacity;
        this.workInterval = workInterval;
        this.location     = location;
        this.free         = true;
        this.schedule     = new Schedule();
    }

    // Геттеры
    public int            getId()           { return id; }
    public String         getName()         { return name; }
    public CourierType    getType()         { return type; }
    public double         getSpeed()        { return speed; }
    public double         getLoadCapacity() { return loadCapacity; }
    public LocalDateTime  getWorkStart()    { return workInterval.getStart(); }
    public LocalDateTime  getWorkEnd()      { return workInterval.getEnd(); }
    public Point          getLocation()     { return location; }
    public boolean        isFree()          { return free; }
    public Schedule       getSchedule()     { return schedule; }

    // Сеттеры для изменяемых полей
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
        return this == o
                || (o instanceof Courier c && id == c.id);
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
                type.getTypeName(),
                speed,
                loadCapacity,
                workInterval.getStart().format(Time.FMT),
                workInterval.getEnd()  .format(Time.FMT),
                location,
                free
        );
    }
}