package org.example.workwithdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveDataToFile implements  SaveData{
    @Override
    public void save(String path, List<Object> data) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)))) {
            //bufferedWriter.write(purposes.size() + "\n");
           /* bufferedWriter.write("Курьер" + purpose.getCourier().getNameSurnameFatherland() +
                    "Номер заказа " + purpose.getOrder().getNumberOrder() + ", " +
                    "Положение по X " + purpose.getOrder().getDeliveryPoint().getX() + ", " +
                    "Положение по Y " + purpose.getOrder().getDeliveryPoint().getY() + ", " +
                    "Временной интервал " + purpose.getTimeMoment() + ", "
                    + "Расстояние " + purpose.getRouteLength() + "\n ");*/
        } catch (IOException e) {
            throw new RuntimeException("Не верный файл: " + e.getMessage());
        }
    }
}
