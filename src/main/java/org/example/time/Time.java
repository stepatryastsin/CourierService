package org.example.time;

public class Time {
    private String startTimeInterval;
    private String endTimeInterval;

    public Time(String startTimeInterval, String endTimeInterval) {
        if(TimeBuilder.isValidTime(startTimeInterval)&&
           TimeBuilder.isValidTime(endTimeInterval)&&
          TimeBuilder.isValidTime(startTimeInterval,endTimeInterval)) {
            this.startTimeInterval = startTimeInterval;
            this.endTimeInterval = endTimeInterval;
        }
    }

    public String getStartTimeInterval() {
        return startTimeInterval;
    }

    public void setStartTimeInterval(String startTimeInterval) {
        if(TimeBuilder.isValidTime(startTimeInterval)) {
            this.startTimeInterval = startTimeInterval;
        }
    }
    public String getEndTimeInterval() {
        return endTimeInterval;
    }
    public void setEndTimeInterval(String endTimeInterval) {
        if(TimeBuilder.isValidTime(endTimeInterval)) {
            this.endTimeInterval = endTimeInterval;
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "startTimeInterval='" + startTimeInterval + '\'' +
                ", endTimeInterval='" + endTimeInterval + '\'' +
                '}';
    }
}
