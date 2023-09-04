package com.tms.springboot.dao;

import com.tms.springboot.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodsForWorkWithDatabase {

    @Autowired
    private SessionFactory factory;


    public void save(List<Car> cars) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Car car : cars) {
            session.save(car);
        }
        transaction.commit();
        session.close();

    }

    public void delete(Integer number){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car carFromDB = session.get(Car.class, number);
        session.delete(carFromDB);
        transaction.commit();
        session.close();
    }

    public void update(Integer number, Boolean available){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car carFromDB = session.get(Car.class, number);
        carFromDB.setAvailability(available);
        session.update(carFromDB);
        transaction.commit();
        session.close();
    }

    public List<Car> getAllData(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> carsFromDB = session.createQuery("SELECT a FROM Car a", Car.class).getResultList();
        transaction.commit();
        session.close();
        return carsFromDB;
    }

}
