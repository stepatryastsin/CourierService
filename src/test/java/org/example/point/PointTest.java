package org.example.point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void distancePointValidOne() {
        assertEquals(Point.distanceFourPoint(3,4,7,4),4);
    }
    @Test
    void distancePointNoValid() {
        assertEquals(Point.distanceFourPoint(0,0,0,0),0);
    }

}