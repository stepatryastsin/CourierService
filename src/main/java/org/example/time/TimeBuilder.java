package org.example.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeBuilder {
    private static String format = "mm:ss";
   private static SimpleDateFormat dateFormat;

    public static boolean isValidTime(String time) {

        // Regex to check valid time in 12-hour format.
        String regexPattern
                = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

        // Compile the ReGex
        Pattern compiledPattern
                = Pattern.compile(regexPattern);

        // If the time is empty
        // return false
        if (time == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given time
        // and regular expression.
        Matcher m = compiledPattern.matcher(time);

        // Return if the time
        // matched the ReGex
            return m.matches();

    }
    public static boolean isValidTime(String s1,String s2){
        dateFormat = new SimpleDateFormat(format);
        try {
            return ((dateFormat.parse(s2).getTime()-dateFormat.parse(s1).getTime())/1000)>0;
        } catch (ParseException e) {
            throw new RuntimeException("Не коректное время");
        }
    }
    public static long getTime(String s1,String s2)  {
        dateFormat = new SimpleDateFormat(format);
        try {
            return (dateFormat.parse(s2).getTime()-dateFormat.parse(s1).getTime())/1000;
        } catch (ParseException e) {
            throw new RuntimeException("Не коректное время");
        }

    }
}
