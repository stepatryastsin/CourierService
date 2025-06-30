package org.example.algorithm;

import org.example.entity.couriers.Courier;
import org.example.entity.utils.Point;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State {
    private Point loc;
    private LocalDateTime currentTime;
    private final LocalDateTime shiftEnd;
    private final List<Purpose> route = new ArrayList<>();

    public State(Courier courier) {
        // Теперь берем начало и конец смены из Time workInterval
        LocalDateTime shiftStart = courier.getWorkInterval().getStart();
        this.shiftEnd            = courier.getWorkInterval().getEnd();

        this.loc         = courier.getLocation();
        this.currentTime = shiftStart;
    }

    public LocalDateTime now() {
        return currentTime;
    }

    public LocalDateTime shiftEnd() {
        return shiftEnd;
    }

    public Point getLocation() {
        return loc;
    }

    public List<Purpose> getRoute() {
        return Collections.unmodifiableList(route);
    }

    public void applyPurpose(Purpose p) {
        LocalDateTime end = p.getTimeWindow().getEnd();
        this.currentTime = end;
        this.loc         = p.getEndPoint();
        this.route.add(p);
    }

}