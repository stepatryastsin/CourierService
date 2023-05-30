package org.example.distanceAndTime;

import org.example.abstractOrder.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortedOrder {
    public  List<Order> compare(List<Order> orders) throws ParseException {
        List<Order> newList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        List<String> firstOrderTime = new ArrayList<>();
        List<String> secondOrderTime =  new ArrayList<>();
        List<Date> firstOrderTimeDateFormat = new ArrayList<>();
        List<Date> secondOrderTimeDateFormat = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            firstOrderTime.add(orders.get(i).getTime().getStartTimeInterval());
            secondOrderTime.add(orders.get(i).getTime().getEndTimeInterval());
        }
        for (int i = 0; i < orders.size(); i++) {
                firstOrderTimeDateFormat.add(simpleDateFormat.parse(firstOrderTime.get(i)));
                secondOrderTimeDateFormat.add(simpleDateFormat.parse(secondOrderTime.get(i)));
        }

        Collections.sort(firstOrderTimeDateFormat);
        Collections.sort(secondOrderTimeDateFormat);
        for (int i = 0; i < orders.size(); i++) {
            for (int j = 0; j < orders.size(); j++) {
              if(firstOrderTimeDateFormat.get(i).toString().substring(14,19).equals(orders.get(j).getTime().getStartTimeInterval())&&
                 secondOrderTimeDateFormat.get(i).toString().substring(14,19).equals(orders.get(j).getTime().getEndTimeInterval())){
                  newList.add(orders.get(j));
                  break;
              }
            }
        }
       return newList;
    }
}