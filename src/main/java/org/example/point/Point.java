package org.example.point;

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
            return (double) Math.sqrt(Math.pow((x - getX()), 2) + Math.pow((y - getY()), 2));
        }
        throw new Exception("Проверьте точки!");
    }
    public double distancePoint(Point z) throws Exception {
        if (z.getX() != getX() && z.getY() != getY()) {
            return Math.sqrt(Math.pow((z.getX() - getX()), 2) + Math.pow((z.getY() - getY()), 2));
        }
        throw new Exception("Проверьте точки!");
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
