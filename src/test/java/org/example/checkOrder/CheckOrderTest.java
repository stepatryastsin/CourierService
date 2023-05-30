package org.example.checkOrder;

import org.example.abstractOrder.Order;
import org.example.abstractPerson.Person;
import org.example.checkCourier.CheckCourier;
import org.example.checkCourier.ICheckCourier;
import org.example.enumType.EnumCourier;
import org.example.enumType.EnumOrder;
import org.example.fabricOrder.BuilderOrder;
import org.example.fabricPerson.BuilderPerson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//0 но < 3 (кг)
class CheckOrderTest {

    @Test
    void checkOrderLightValid() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.LIGHT).weight(3).build();
        assertEquals(checkOrder.checkOrderLight(person),true);
    }
    @Test
    void checkOrderLightBadDataOne() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.LIGHT).weight(7).build();
        assertEquals(checkOrder.checkOrderLight(person),false);
    }
    @Test
    void checkOrderLightBadDataTwo() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.LIGHT).weight(0).build();
        assertEquals(checkOrder.checkOrderLight(person),false);
    }

    @Test
    void checkOrderMediumValid() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.MEDIUM).weight(4).build();
        assertEquals(checkOrder.checkOrderMedium(person),true);
    }
    @Test
    void checkOrderMediumBadDataOne() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.MEDIUM).weight(7).build();
        assertEquals(checkOrder.checkOrderMedium(person),false);
    }
    @Test
    void checkOrderMediumBadDataTwo() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.MEDIUM).weight(0).build();
        assertEquals(checkOrder.checkOrderMedium(person),false);
    }
    @Test
    void checkOrderHard() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.HARD).weight(9).build();
        assertEquals(checkOrder.checkOrderHard(person),true);
    }
    @Test
    void checkOrderHardBadDataOne() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.MEDIUM).weight(11).build();
        assertEquals(checkOrder.checkOrderHard(person),false);
    }
    @Test
    void checkOrderHardBadDataTwo() throws Exception {
        ICheckOrder checkOrder = new CheckOrder();
        Order person = new BuilderOrder(EnumOrder.MEDIUM).weight(0).build();
        assertEquals(checkOrder.checkOrderHard(person),false);
    }
}