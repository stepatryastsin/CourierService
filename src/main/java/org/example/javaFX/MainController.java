package org.example.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.entity.*;
import org.example.basicAlgorithm.BasicAlgorithm;
import org.example.schedule.Schedule;

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
    List<Courier> persons = new ArrayList();
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
    @FXML private TextField randomOrderCount;
    @FXML private Button generateOrdersBtn;
    @FXML private TextField randomCourierCount;
    @FXML private Button generateCouriersBtn;
    @FXML
    private void generateRandomOrders(ActionEvent event) {
        int n = Integer.parseInt(randomOrderCount.getText());
        for (int i = 0; i < n; i++) {

        }
    }

    @FXML
    private void generateRandomCouriers(ActionEvent event) {
        int m = Integer.parseInt(randomCourierCount.getText());
        for (int i = 0; i < m; i++) {

        }
    }
    public void AddOrder(ActionEvent event) throws Exception {

        float xStart = Float.parseFloat(xStartOrder.getText());
        float yStart = Float.parseFloat(yStartOrder.getText());

        float yEnd = Float.parseFloat(yEndOrder.getText());
        float xEnd = Float.parseFloat(xEndOrder.getText());

        Point start = new Point (xStart, yStart);
        Point end = new Point(xEnd,yEnd);
        String time1 = startTimeOrder.getText();
        String time2 = endTimeOrder.getText();
        Time time = new Time(time1,time2);
        double weight = Double.parseDouble(weightOrder.getText());
        OrderFactory  factoryOrder = new OrderFactory();
        switch (OrderType.getText()) {

            case "Light":
                Order orderLight = factoryOrder.create(start,end,time,weight,EnumOrder.LIGHT);
                orders.add(orderLight);
                OrderList.getItems().add(orderLight.toString());
                break;
            case "Medium":
                Order mediumLight = factoryOrder.create(start,end,time,weight,EnumOrder.MEDIUM);
                orders.add(mediumLight);
                OrderList.getItems().add(mediumLight.toString());
                break;
            case "Hard":
                Order hardLight = factoryOrder.create(start,end,time,weight,EnumOrder.HARD);
                orders.add(hardLight);
                OrderList.getItems().add(hardLight.toString());
                break;
        }

    }

    public void AddCourier(ActionEvent event) throws Exception {

        String name = nameCourier.getText();
        double speed = Double.parseDouble(speedCourier.getText());
        float x = Float.parseFloat(xCourier.getText());
        float y = Float.parseFloat(yCourier.getText());
        double energy = Double.parseDouble(energyCourier.getText());
        Point point = new Point(x,y);
        String time1 = courierTimeStart.getText();
        String time2 = courierTimeEnd.getText();
        CourierFactory factoryCourier = new CourierFactory();
        switch (CourierType.getText()){
            case "By foot":
                Courier courierPeople = factoryCourier.create(name,EnumCourier.PEDESTRIAN,speed,energy,time1,time2,point);
                persons.add(courierPeople);
                CourierList.getItems().add(courierPeople.toString());
                break;
            case "By bike":
                Courier bikePeople = factoryCourier.create(name,EnumCourier.BICYCLE,speed,energy,time1,time2,point);
                persons.add(bikePeople);
                CourierList.getItems().add(bikePeople.toString());
                break;
            case "By car":
                Courier carPeople = factoryCourier.create(name,EnumCourier.CAR,speed,energy,time1,time2,point);
                persons.add(carPeople);
                CourierList.getItems().add(carPeople.toString());
                break;
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
