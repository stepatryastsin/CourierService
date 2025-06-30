package org.example.algorithm;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private final List<Purpose> allPurposes;
    private double incomeSum;
    private double totalDistance;

    public Schedule(List<Purpose> list) {
        this.allPurposes = new ArrayList<>(list);
        for (Purpose p : allPurposes) {
            incomeSum     += p.getIncome();
            totalDistance += p.getRouteDistance();
        }
    }

    public List<Purpose>  getAllPurposes()    { return allPurposes; }
    public double         getIncomeSchedule() { return incomeSum; }
    public double         getTotalDistance()  { return totalDistance; }

    public void beautifulPrint() {
        allPurposes.forEach(System.out::println);
        System.out.println("Общий доход: " + Math.round(incomeSum) + "₽");
        System.out.println("Общая дистанция: " + Math.round(totalDistance) + " м");
    }
}