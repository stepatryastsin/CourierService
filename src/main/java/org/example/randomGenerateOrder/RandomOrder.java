package org.example.randomGenerateOrder;

import org.example.abstractOrder.Order;
import org.example.enumType.EnumOrder;
import org.example.fabricOrder.BuilderOrder;
import org.example.point.Point;

import org.example.time.TimeBuilder;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Класс генерирует заказы {@link Order} с разными полями для стресс теста
 */
public class RandomOrder {
    private List<Order> orderList = new ArrayList<>();
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    private int generateId(){
        Random random = new Random();
        return random.nextInt();
    }
    private int generateNumber(int min,int max){
        Random rn = new Random();
        int range = max - min + 1;
        int randomNum =  rn.nextInt(range) + min;
        return randomNum;
    }
    public List<String> generateTime(){
        List<String> time = new ArrayList<>();
        String timeParseOne;
        String timeParseTwo;
        do {
            final Random random = new Random();
            final int millisInDayOne = 24 * 60 * 60 * 1000;
            final int millisInDayTwo = 24 * 60 * 60 * 1000;
            Time timeOne = new Time((long) random.nextInt(millisInDayOne));
            Time timeTwo = new Time((long) random.nextInt(millisInDayTwo));
            timeParseOne = timeOne.toString().substring(0, 5);
            timeParseTwo = timeTwo.toString().substring(0, 5);
            time.clear();
        }
        while(TimeBuilder.getTime(timeParseTwo,timeParseOne)>0);
        time.add(timeParseOne);
        time.add(timeParseTwo);
        return time;
    }
    /**
     * Метод {@link RandomOrder#getAllList}  генерирует колличество заказов по передаваемому числу.
     */
    public List<Order> getAllList(int count) throws Exception {
        for (int i = 0; i < count; i++) {
            orderList.add(new BuilderOrder(randomEnum(EnumOrder.class)).id(generateId()).
                            pointStart(new Point(generateNumber(0,100),generateNumber(0,100))).
                            pointFinish(new Point(generateNumber(0,100),generateNumber(0,100))).
                    time(new org.example.time.Time(generateTime().get(0),generateTime().get(1))).build());
        }
        return orderList;
    }
}
