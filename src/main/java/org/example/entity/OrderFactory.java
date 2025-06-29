package org.example.entity;

import org.example.utils.GenerateID;

public class OrderFactory  {
    private final GenerateID generator;

    public OrderFactory() {
        this.generator = new GenerateID();
    }
    public Order create(Point start,
                        Point finish,
                        Time time,
                        double weight,
                        EnumOrder type){
        int id = generator.getId();
        return new Order(id,start,finish,time,weight,type);
    }

}