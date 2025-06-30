package org.example.time;

import org.example.entity.utils.Time;
import org.junit.jupiter.api.Test;

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