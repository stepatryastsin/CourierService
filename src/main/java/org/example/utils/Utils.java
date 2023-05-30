package org.example.utils;

import org.apache.maven.plugin.lifecycle.Execution;
import org.example.abstractOrder.Order;
import org.example.abstractPerson.Person;
import org.example.point.Point;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String timeExecution (int timeStartInterval, String time) {
        if (timeStartInterval == 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime lt = LocalTime.parse(time);
            return formatter.format(lt.plusMinutes(1));
        }
        if (timeStartInterval < 0) {
            throw new RuntimeException("Неверное время!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        return formatter.format(lt.plusMinutes(timeStartInterval));
    }

    public static void swapLocation (Person courier, Order order) {
        courier.setLocation(order.getPointFinish());
    }

}
