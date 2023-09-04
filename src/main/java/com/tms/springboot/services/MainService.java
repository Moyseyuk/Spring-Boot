package com.tms.springboot.services;

import com.tms.springboot.dao.MethodsForWorkWithDatabase;
import com.tms.springboot.model.CARMODEL;
import com.tms.springboot.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private MethodsForWorkWithDatabase repository;

    @PostConstruct
    public void init() throws NullPointerException{
        Car car1 = new Car(CARMODEL.AUDI, new Date(98, 7, 9), true);
        Car car2 = new Car(CARMODEL.BMW, new Date(84, 1, 20), false);
        Car car3 = new Car(CARMODEL.MERCEDES, new Date(111, 2, 11), true);
        Car car4 = new Car(CARMODEL.VOLVO, new Date(103, 5, 7), true);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

            repository.save(cars);
            repository.update(1, false);
            repository.delete(2);
            repository.getAllData();
        System.out.println("end");
    }

}
