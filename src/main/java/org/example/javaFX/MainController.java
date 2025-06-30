package org.example.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.basicAlgorithm.BasicAlgorithm;
import org.example.entity.couriers.Courier;
import org.example.entity.couriers.CourierFactory;
import org.example.entity.couriers.CourierTypeFactory;
import org.example.entity.couriers.RandomCourier;
import org.example.entity.utils.Point;
import org.example.entity.utils.Purpose;
import org.example.entity.utils.Time;
import org.example.entity.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.example.entity.order.Order;
import org.example.entity.order.OrderFactory;
import org.example.entity.order.OrderTypeFactory;
import org.example.entity.order.RandomOrder;

public class MainController {

    @FXML private Button StartButton;

    @FXML private ListView<String> CourierList;
    @FXML private ListView<String> OrderList;
    @FXML private ListView<Purpose> ResultList;

    @FXML private TextField courierTimeStart;
    @FXML private TextField courierTimeEnd;
    @FXML private SplitMenuButton CourierType;

    @FXML private TextField randomOrderCount;
    @FXML private TextField randomCourierCount;
    @FXML private SplitMenuButton OrderType;

    @FXML private Label distanceField;
    @FXML private Label outcomeField;

    @FXML private TextField yCourier;
    @FXML private TextField xCourier;
    @FXML private TextField energyCourier;
    @FXML private TextField speedCourier;
    @FXML private TextField nameCourier;

    @FXML private TextField endTimeOrder;
    @FXML private TextField startTimeOrder;
    @FXML private TextField xStartOrder;
    @FXML private TextField yStartOrder;
    @FXML private TextField xEndOrder;
    @FXML private TextField yEndOrder;
    @FXML private TextField weightOrder;

    private final List<Order> orders = new ArrayList<>();
    private final List<Courier> persons = new ArrayList<>();

    @FXML
    private void generateRandomOrders(ActionEvent event) {
        int count = parseInt(randomOrderCount);
        IntStream.range(0, count)
                .mapToObj(i -> RandomOrder.getRandomOrder())
                .peek(order -> {
                    orders.add(order);
                    OrderList.getItems().add(order.toString());
                })
                .forEach(o -> {});
    }

    @FXML
    private void generateRandomCouriers(ActionEvent event) {
        int count = parseInt(randomCourierCount);
        IntStream.range(0, count)
                .mapToObj(i -> RandomCourier.getRandomCourier())
                .peek(courier -> {
                    persons.add(courier);
                    CourierList.getItems().add(courier.toString());
                })
                .forEach(c -> {});
    }

    @FXML
    private void AddOrder(ActionEvent event) {
        Order order = createOrderFromFields();
        orders.add(order);
        OrderList.getItems().add(order.toString());
    }

    @FXML
    private void AddCourier(ActionEvent event) {
        Courier courier = createCourierFromFields();
        persons.add(courier);
        CourierList.getItems().add(courier.toString());
    }

    @FXML
    private void StartApplication(ActionEvent event) {
        ResultList.getItems().clear();

        Schedule schedule = BasicAlgorithm.basicAlgorithm(persons, orders);
        schedule.getAllPurpose().forEach(ResultList.getItems()::add);

        outcomeField.setText(String.valueOf(Math.round(schedule.getIncomeSchedule())));
        distanceField.setText(String.valueOf(Math.round(schedule.getTotalLength())));
    }

    @FXML private void LightOrder(ActionEvent event) throws Exception { OrderType.setText("Light"); }
    @FXML private void MediumOrder(ActionEvent event) throws Exception{ OrderType.setText("Medium"); }
    @FXML private void HardOrder(ActionEvent event) throws Exception  { OrderType.setText("Hard"); }

    @FXML private void BikeCourier(ActionEvent event)  { CourierType.setText("By bike"); }
    @FXML private void CarCourier(ActionEvent event)   { CourierType.setText("By car"); }
    @FXML private void PeopleCourier(ActionEvent event){ CourierType.setText("By foot"); }

    @FXML private void ClearCourierList(ActionEvent event){
        persons.clear();
        CourierList.getItems().clear();
    }

    @FXML private void ClearOrderList(ActionEvent event){
        orders.clear();
        OrderList.getItems().clear();
    }

    // ======= Helper methods =======

    private int parseInt(TextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Order createOrderFromFields() {
        Point start  = new Point(parseFloat(xStartOrder), parseFloat(yStartOrder));
        Point finish = new Point(parseFloat(xEndOrder), parseFloat(yEndOrder));
        Time  time   = new Time(startTimeOrder.getText(), endTimeOrder.getText());
        double weight = parseDouble(weightOrder);
        String typeKey = OrderType.getText().toUpperCase();
        var type = OrderTypeFactory.getByName(typeKey);

        return new OrderFactory().create(start, finish, time, weight, type);
    }

    private Courier createCourierFromFields() {
        String name    = nameCourier.getText();
        double speed   = parseDouble(speedCourier);
        double capacity= parseDouble(energyCourier);
        Point location = new Point(parseFloat(xCourier), parseFloat(yCourier));
        Time workTime  = new Time(courierTimeStart.getText(), courierTimeEnd.getText());

        String text = CourierType.getText();
        var type = switch (text) {
            case "By foot" -> CourierTypeFactory.getByName("PEDESTRIAN");
            case "By bike" -> CourierTypeFactory.getByName("BICYCLE");
            case "By car"  -> CourierTypeFactory.getByName("CAR");
            default -> throw new IllegalArgumentException("Unknown courier type: " + text);
        };

        return new CourierFactory().create(name, type, speed, capacity, workTime, location);
    }

    private float parseFloat(TextField field) {
        try {
            return Float.parseFloat(field.getText());
        } catch (NumberFormatException e) {
            return 0f;
        }
    }

    private double parseDouble(TextField field) {
        try {
            return Double.parseDouble(field.getText());
        } catch (NumberFormatException e) {
            return 0d;
        }
    }
}
