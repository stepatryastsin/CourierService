package org.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void timeExecution() {
        System.out.println(Utils.timeExecution(78, "13:58"));
    }
}