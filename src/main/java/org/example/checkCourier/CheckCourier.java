package org.example.checkCourier;

import org.example.person.Person;

public class CheckCourier implements ICheckCourier{

    @Override
    public boolean checkCarCourier(Person person) throws Exception {
        if((person.getSpeed()>0&&person.getSpeed()<60)&&(person.getEnergy()>0&&person.getEnergy()<10)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPeopleCourier(Person person) throws Exception {
        if((person.getSpeed()>0&&person.getSpeed()<10)&&(person.getEnergy()>0&&person.getEnergy()<3)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkBikeCourier(Person person) throws Exception {
        if((person.getSpeed()>0&&person.getSpeed()<20)&&(person.getEnergy()>0&&person.getEnergy()<5)){
            return true;
        }
        return false;
    }
}
