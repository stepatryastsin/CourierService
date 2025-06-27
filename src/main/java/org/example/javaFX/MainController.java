package org.example.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.entity.Order;
import org.example.entity.Person;
import org.example.basicAlgorithm.BasicAlgorithm;
import org.example.entity.EnumCourier;
import org.example.entity.EnumOrder;
import org.example.fabricOrder.BuilderOrder;
import org.example.fabricPerson.BuilderPerson;
import org.example.entity.Point;
import org.example.entity.Purpose;
import org.example.schedule.Schedule;
import org.example.entity.Time;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML

    public Button StartButton;

    public ListView <String> CourierList;

    public ListView <String> OrderList;
    public ListView ResultList;
    public TextField courierTimeStart;
    public TextField courierTimeEnd;
    public SplitMenuButton CourierType;
    public SplitMenuButton OrderType;
    public Label distanceField;
    public Label outcomeField;
    List<Order> orders = new ArrayList<>();
    List<Person> persons = new ArrayList();
    public TextField yCourier;
    public TextField xCourier;
    public TextField energyCourier;
    public TextField endTimeOrder;
    public TextField startTimeOrder;
    public TextField xStartOrder;
    public TextField xEndOrder;
    public TextField yStartOrder;
    public TextField yEndOrder;
    public TextField weightOrder;
    public TextField speedCourier;
    public TextField nameCourier;

    public void AddOrder(ActionEvent event) throws Exception {

        int id = 1 + OrderList.getItems().size();
        double xStart = Double.parseDouble(xStartOrder.getText());
        double yStart = Double.parseDouble(yStartOrder.getText());

        double yEnd = Double.parseDouble(yEndOrder.getText());
        double xEnd = Double.parseDouble(xEndOrder.getText());

        Point start = new Point (xStart, yStart);
        Point end = new Point(xEnd,yEnd);
        String time1 = startTimeOrder.getText();
        String time2 = endTimeOrder.getText();
        Time time = new Time(time1,time2);
        double weight = Double.parseDouble(weightOrder.getText());
        switch (OrderType.getText()) {

            case "Light":
                Order orderLight = new BuilderOrder(EnumOrder.LIGHT).id(id).pointStart(start).pointFinish(end).time(time).weight(weight).build();
                orders.add(orderLight);
                OrderList.getItems().add(orderLight.toString());
                return;
            case "Medium":
                Order mediumLight = new BuilderOrder(EnumOrder.MEDIUM).id(id).pointStart(start).pointFinish(end).time(time).weight(weight).build();
                orders.add(mediumLight);
                OrderList.getItems().add(mediumLight.toString());
                return;
            case "Hard":
                Order hardLight = new BuilderOrder(EnumOrder.HARD).id(id).pointStart(start).pointFinish(end).time(time).weight(weight).build();
                orders.add(hardLight);
                OrderList.getItems().add(hardLight.toString());
                return;
            case "Type":
                Order order = new Order(id, start, end, time,weight);
                orders.add(order);
                OrderList.getItems().add(order.toString());
                return;
        }

    }

    public void AddCourier(ActionEvent event) throws Exception {

        int id = 1 + CourierList.getItems().size();
        String name = nameCourier.getText();
        double speed = Double.parseDouble(speedCourier.getText());
        double x = Double.parseDouble(xCourier.getText());
        double y = Double.parseDouble(yCourier.getText());
        double energy = Double.parseDouble(energyCourier.getText());
        Point point = new Point(x,y);
        String time1 = courierTimeStart.getText();
        String time2 = courierTimeEnd.getText();

        switch (CourierType.getText()){
            case "By foot":
                Person courierPeople = new BuilderPerson(EnumCourier.PEOPLE).id(id).energy(energy).speed(speed).location(point).name(name).build();
                persons.add(courierPeople);
                CourierList.getItems().add(courierPeople.toString());
                return;
            case "By bike":
                Person bikePeople = new BuilderPerson(EnumCourier.BIKE).id(id).energy(energy).speed(speed).location(point).name(name).build();
                persons.add(bikePeople);
                CourierList.getItems().add(bikePeople.toString());
                return;
            case "By car":
                Person carPeople = new BuilderPerson(EnumCourier.CAR).id(id).energy(energy).speed(speed).location(point).name(name).build();
                persons.add(carPeople);
                CourierList.getItems().add(carPeople.toString());
                return;
            case "Type":
                Person courier = new Person(id, name, speed, energy, time1,time2, point);
                persons.add(courier);
                CourierList.getItems().add(courier.toString());
                return;
        }
    }

    public void StartApplication(ActionEvent event) {
        ResultList.getItems().clear();
        Schedule schedule = BasicAlgorithm.basicAlgorithm(persons,orders);
        for (Purpose helpPurpose : schedule.getAllPurpose()) {
            ResultList.getItems().add(helpPurpose);
        }

        double outcome = Math.round(schedule.getIncomeSchedule());
        double distance = Math.round(schedule.getTotalLength());

        outcomeField.setText(Double.toString(outcome));
        distanceField.setText(Double.toString(distance));


    }

    public void LightOrder(ActionEvent event) throws Exception {
        OrderType.setText("Light");
    }

    public void MediumOrder(ActionEvent event) throws Exception {

        OrderType.setText("Medium");
    }

    public void HardOrder(ActionEvent event) throws Exception {
        OrderType.setText("Hard");

    }

    public void BikeCourier(ActionEvent event) {
        CourierType.setText("By bike");
    }

    public void CarCourier(ActionEvent event) {
        CourierType.setText("By car");
    }

    public void PeopleCourier(ActionEvent event) {
        CourierType.setText("By foot");
    }

    public void ClearCourierList(ActionEvent event) {
        CourierList.getItems().clear();
        persons.clear();
    }

    public void ClearOrderList(ActionEvent event) {
        OrderList.getItems().clear();
        orders.clear();
    }


}
