package org.example.time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    @Test
    void setStartTimeInterval() {
        Time time = new Time("12:00","14:00");
        assertEquals(time.getEndTimeInterval(),"14:00");
    }

    @Test
    void setEndTimeInterval() {
    }
}