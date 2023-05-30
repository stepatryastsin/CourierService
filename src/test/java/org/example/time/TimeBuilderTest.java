package org.example.time;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TimeBuilderTest {

    @org.junit.jupiter.api.Test
    void getSecond() throws ParseException {
        assertEquals(TimeBuilder.getTime("12:00","13:0"),60);
    }


}