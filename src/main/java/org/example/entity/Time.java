package org.example.entity;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public final class Time {
    private final LocalDateTime start;
    private final LocalDateTime end;
    public static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");

    public Time(String startStr, String endStr) {
        try{
            this.start = LocalDateTime.parse(startStr,FMT);
            this.end   = LocalDateTime.parse(endStr,FMT);
        }catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(
                    "Invalid time format, expected dd.MM.yyyy-HH:mm:ss", ex);
        }
    }

    public LocalDateTime getStart() {
        return start;
    }
    public LocalDateTime getEnd() {
        return end;
    }

    public long durationSeconds() {
        return Duration.between(start, end).getSeconds();
    }
    public long durationMinutes() {
        return Duration.between(start, end).toMinutes();
    }
    public long durationHours() {
        return Duration.between(start, end).toHours();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Time)) return false;

        Time time = (Time) o;
        return getStart().equals(time.getStart()) && getEnd().equals(time.getEnd());
    }

    @Override
    public int hashCode() {
        int result = getStart().hashCode();
        result = 31 * result + getEnd().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return start.format(FMT) + " to " + end.format(FMT);
    }
}
