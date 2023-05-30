package org.example.schedule;
import org.example.abstractPerson.Person;
import org.example.pupose.Purpose;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Класс необходимый для создания рассписания курьеров основанный на {@link Purpose} хранящиеся в {@link Schedule#allPurpose}
 */
public class Schedule {
    private List<Purpose> allPurpose;
    private double incomeSchedule;
    private double totalLength;

    public Schedule(List<Purpose> allPurpose) {
        this.allPurpose = allPurpose;
        for (Purpose helpPurpose : allPurpose) {
            this.incomeSchedule += helpPurpose.getIncome();
            this.totalLength += helpPurpose.getRouteLength();
        }
    }

    public Schedule() {
        this.allPurpose = new ArrayList<>();
    }

    public List<Purpose> getAllPurpose() {
        return allPurpose;
    }

    public void addPurpose(Purpose purpose) {
        allPurpose.add(purpose);
        this.incomeSchedule += purpose.getIncome();
        this.totalLength += purpose.getRouteLength();
    }

    public Schedule merge (List<Purpose> listSecond) {
        this.allPurpose.addAll(listSecond);
        return this;
    }

    public double getIncomeSchedule() {
        return incomeSchedule;
    }
    public double getTotalLength() {
        return totalLength;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "allPurpose=" + allPurpose +
                '}';
    }

    public void beautifulString() {
        for (Purpose helpPurpose : allPurpose) {
            System.out.println(helpPurpose);
        }
        System.out.println("Общий доход со всех заказов: " + Math.round(getIncomeSchedule())
                + " рубля(ей).");
        System.out.println("Общая пройденная дистанция: " + Math.round(getTotalLength())
                + " метра(ов).");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(allPurpose, schedule.allPurpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allPurpose);
    }
}