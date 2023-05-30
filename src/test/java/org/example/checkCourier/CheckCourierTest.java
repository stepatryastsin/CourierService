package org.example.checkCourier;

import org.example.abstractPerson.Person;
import org.example.enumType.EnumCourier;
import org.example.fabricPerson.BuilderPerson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckCourierTest {

    @Test
    void checkCarCourierValid() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.CAR).speed(4.3).energy(6).build();
        assertEquals(checkCourier.checkCarCourier(person),true);
    }
    @Test
    void checkCarCourierBadDataOne() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.CAR).speed(0).energy(4).build();
        assertEquals(checkCourier.checkCarCourier(person),false);
    }
    @Test
    void checkCarCourierBadDataTwo() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.CAR).speed(11).energy(11).build();
        assertEquals(checkCourier.checkCarCourier(person),false);
    }
    @Test
    void checkPeopleCourierValid() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.PEOPLE).speed(1.5).energy(2).build();
        assertEquals(checkCourier.checkCarCourier(person),true);
    }

    @Test
    void checkPeopleCourierBadOne() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.PEOPLE).speed(1.5).energy(2).build();
        assertEquals(checkCourier.checkCarCourier(person),true);
    }
    @Test
    void checkPeopleCourierBadTwo() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.PEOPLE).speed(0).energy(2).build();
        assertEquals(checkCourier.checkCarCourier(person),false);
    }
    @Test
    void checkPeopleBikeValid() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.BIKE).speed(3.5).energy(4).build();
        assertEquals(checkCourier.checkCarCourier(person),true);
    }

    @Test
    void  checkPeopleBikeBadOne() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.BIKE).speed(6).energy(2).build();
        assertEquals(checkCourier.checkCarCourier(person),true);
    }
    @Test
    void checkBikeCourierBadTwo() throws Exception {
        ICheckCourier checkCourier = new CheckCourier();
        Person person = new BuilderPerson(EnumCourier.BIKE).speed(0).energy(4).build();
        assertEquals(checkCourier.checkCarCourier(person),false);
    }
}