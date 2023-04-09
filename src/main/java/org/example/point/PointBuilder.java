package org.example.point;

public class PointBuilder {
    public static boolean pointIsValid(double x, double y) {
        try {
            return (x >= 0) && (y >= 0)&&(x <= 100) && (y <= 100);
        }
        catch (RuntimeException e){
            throw new RuntimeException("Не коректные точки");
        }
    }
    public static boolean pointIsValid(double a) {
        try {
            return (a >= 0) && (a <= 100) ;
        }
        catch (RuntimeException e){
            throw new RuntimeException("Не коректные точки");
        }
    }
}
