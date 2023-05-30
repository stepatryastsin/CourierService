package org.example.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Класс реализует проверки для времени : формат и разницу во времени, при которой t2 - t1 > 0
 */
public class TimeBuilder {

    private static String format = "mm:ss";
   private static SimpleDateFormat dateFormat;
    /**
     * Метод {@link TimeBuilder#isValidTime(String)} проверяет формат времени
     */
    public static boolean isValidTime(String time) {
        String regexPattern
                = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

        Pattern compiledPattern
                = Pattern.compile(regexPattern);
        if (time == null) {
            return false;
        }
        Matcher m = compiledPattern.matcher(time);
        return m.matches();
    }
    /**
     * Метод {@link TimeBuilder#isValidTime(String)} проверяет формат времени
     */
    public static boolean isValidTime(String s1,String s2){
        dateFormat = new SimpleDateFormat(format);
        try {
            return ((dateFormat.parse(s2).getTime()-dateFormat.parse(s1).getTime())/1000)>0;
        } catch (ParseException e) {
            throw new RuntimeException("Не коректное время");
        }
    }
    /**
     * Метод {@link TimeBuilder#isValidTime(String)} проверяет разницу во времени
     */
    public static long getTime(String s1,String s2)  {
        dateFormat = new SimpleDateFormat(format);
        try {
            return (dateFormat.parse(s2).getTime()-dateFormat.parse(s1).getTime())/1000;
        } catch (ParseException e) {
            throw new RuntimeException("Не коректное время");
        }

    }

}
