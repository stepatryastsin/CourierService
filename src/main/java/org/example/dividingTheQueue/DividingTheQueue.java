package org.example.dividingTheQueue;

import org.example.abstractOrder.Order;
import org.example.abstractPerson.Person;
import org.example.distanceAndTime.SortedOrder;

import java.text.ParseException;
import java.util.*;
/**
 * Вспомогательный класс,  необходимый для создания первичного рассписания и логирования
 */
class DividingTheQueue {
    private static int index = 0;
    /**
     * {@link DividingTheQueue#chopped(List, List)} Метод который позволяет создовать лист листов ,
     * для дальнейшего расспределения заказов между курьерми
     */
    static public List<List<Order>> chopped(List<Order> list, List<Integer> L) throws ParseException {

        List<List<Order>> parts = new ArrayList<>();
        final int N = list.size();
        while(list.size()!=0) {
            parts.add(new ArrayList<Order>(list.subList(0, L.get(index))));
            for (int i = 0; i < L.get(index); i++) {
                list.remove(0);
            }
            index++;
        }
        return parts;
    }
    /**
     * {@link DividingTheQueue#sizeTheOrder(int, int)} На основе количества заказаов, и количества курьеров может сделать расспределение.
     * В случае если закаозов больше, чем курьеров, заказы могут оптимально расспределиться между курьерами.
     *
     */
    public static List<Integer> sizeTheOrder(int sizeOrder, int sizePerson) {
        List<Integer> allDividingNumber = new ArrayList<>();
        double coefficient = sizeOrder / sizePerson;
        for (int i = 0; i < sizePerson; i++) {
            allDividingNumber.add((int) coefficient);
        }
        if (sizeOrder % sizePerson == 0) {
            return allDividingNumber;
        }
        int alfa = (int) (coefficient * sizePerson);
        int needToDistribute = sizeOrder - alfa;
        for (int j = 0; j < needToDistribute; j++) {
            final int one = 1;
            Integer prev = allDividingNumber.get(j) + one;
            allDividingNumber.set(j, prev);
        }

        return allDividingNumber;
    }
}
