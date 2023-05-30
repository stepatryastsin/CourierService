package org.example.point;
/**
 * Класс для создания точки на карте
 */
public class Point {
    private double X;
    private double Y;

    public Point(double x, double y) {
        if(PointBuilder.pointIsValid(X,Y)) {
            X = x;
            Y = y;
        }
    }

    public double getX() {
        return X;
    }

    public void setX(double X) {
        if(PointBuilder.pointIsValid(X)) {
            this.X = X;
        }
    }

    public double getY() {
        return Y;
    }

    public void setY(double Y) {
        if(PointBuilder.pointIsValid(Y)) {
           this.Y = Y;
        }
    }

    public  double distancePoint(double x,double y) throws Exception {
        if (x != getX() && y != getY()) {
            return (double) Math.sqrt(Math.pow(Math.abs(x - getX()), 2) + Math.pow(Math.abs(y - getY()), 2));
        }
        throw new Exception("Проверьте точки!");
    }//Метод который не используется (может удалить)
    public  double distancePoint(Point z) throws Exception {
        if (z.getX() != getX() && z.getY() != getY()) {
            return Math.sqrt(Math.pow(Math.abs(z.getX() - getX()), 2) + Math.pow(Math.abs(z.getY() - getY()), 2));
        }
        throw new Exception("Проверьте точки!");
    }//Метод который не используется (может удалить)
    /**
     * Метод позволяет рассчитать расстояние между двумя точками на сисстеме кординат
     */
    public static double distanceFourPoint (double xStart, double yStart, double xFinish, double yFinish) {
        double distance = Math.sqrt(Math.pow(Math.abs(xFinish - xStart), 2) + Math.pow(Math.abs(yFinish - yStart), 2));
        try {
            if(distance!=0) {
                return distance;
            }
        }catch (RuntimeException e){
            throw new RuntimeException("Проверьте точки");
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

}
