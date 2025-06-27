package org.example.point;

import org.example.entity.Point;
import org.junit.jupiter.api.Test;

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