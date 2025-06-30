package org.example.entity.utils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

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
    public static Time randomBetween(LocalDateTime min, LocalDateTime max) {
        long minEpoch = min.toEpochSecond(ZoneOffset.UTC);
        long maxEpoch = max.toEpochSecond(ZoneOffset.UTC);
        if (maxEpoch <= minEpoch) {
            throw new IllegalArgumentException("max must be after min");
        }
        long randomStart = ThreadLocalRandom
                .current()
                .nextLong(minEpoch, maxEpoch);
        long randomEnd = ThreadLocalRandom
                .current()
                .nextLong(randomStart + 1, maxEpoch + 1);
        LocalDateTime start = LocalDateTime.ofEpochSecond(randomStart, 0, ZoneOffset.UTC);
        LocalDateTime end   = LocalDateTime.ofEpochSecond(randomEnd,   0, ZoneOffset.UTC);
        String startStr     = start.format(FMT);
        String endStr       = end  .format(FMT);
        return new Time(startStr, endStr);
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
