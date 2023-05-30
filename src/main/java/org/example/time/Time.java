package org.example.time;

import org.example.pupose.Purpose;
import org.example.schedule.Schedule;

import java.util.Objects;
/**
 * Класс необходимый для создания времени по формату (X:Y), где X =  {@link Time#startTimeInterval} начало интервала, а где Y =  {@link Time#endTimeInterval} конца интервала
 */
public class Time {
    private String startTimeInterval;
    private String endTimeInterval;

    public Time(String startTimeInterval, String endTimeInterval) {
        if (TimeBuilder.isValidTime(startTimeInterval) &&
                TimeBuilder.isValidTime(endTimeInterval) &&
                TimeBuilder.isValidTime(startTimeInterval, endTimeInterval)) {
            this.startTimeInterval = startTimeInterval;
            this.endTimeInterval = endTimeInterval;
        }
    }

    public String getStartTimeInterval() {
        return startTimeInterval;
    }

    public void setStartTimeInterval(String startTimeInterval) {
        if (TimeBuilder.isValidTime(startTimeInterval)) {
            this.startTimeInterval = startTimeInterval;
        }
    }

    public String getEndTimeInterval() {
        return endTimeInterval;
    }

    public void setEndTimeInterval(String endTimeInterval) {
        if (TimeBuilder.isValidTime(endTimeInterval)) {
            this.endTimeInterval = endTimeInterval;
        }
    }

    public TimeBuilder getTimeBuilder() {
        return new TimeBuilder();
    }
    public long getTimeLongMinute() {
        return new TimeBuilder().getTime(startTimeInterval,endTimeInterval);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(startTimeInterval, time.startTimeInterval) && Objects.equals(endTimeInterval, time.endTimeInterval);
    }

    @Override
    public String toString() {
        return "Time{" +
                "startTimeInterval='" + startTimeInterval + '\'' +
                ", endTimeInterval='" + endTimeInterval + '\'' +
                '}';
    }
}
