package org.example.randomGeneratePeople;

import com.github.javafaker.Faker;
import org.example.entity.Courier;
import org.example.entity.Person;
import org.example.entity.EnumCourier;
import org.example.fabricPerson.BuilderPerson;
import org.example.entity.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPeople {
    private List<Courier> personList = new ArrayList<>();
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    private int generateId(){
        Random random = new Random();
        return random.nextInt();
    }
   private String generateName(){
       Faker faker = new Faker();
       return faker.name().fullName();
   }
   private int generateNumber(int min,int max){
       Random rn = new Random();
       int range = max - min + 1;
       int randomNum =  rn.nextInt(range) + min;
       return randomNum;
   }
    /**
     * Метод {@link RandomPeople#generateNumber}  генерирует колличество заказов по передаваемому числу.
     */
   public List<Courier> getAllList(int count) throws Exception {
       for (int i = 0; i < count; i++) {
           personList.add(new BuilderPerson(randomEnum(EnumCourier.class)).id(generateId()).
                   name(generateName()).
                   speed(generateNumber(1,30)).energy(generateNumber(1,30)).
                   location(new Point(generateNumber(1,100),generateNumber(1,100))).build());
       }
       return personList;
   }
}
