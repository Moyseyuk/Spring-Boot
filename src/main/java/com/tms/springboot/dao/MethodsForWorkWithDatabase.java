package com.tms.springboot.dao;

import com.tms.springboot.dto.CarDto;
import com.tms.springboot.dto.ClientDto;
import com.tms.springboot.model.Car;
import com.tms.springboot.model.Client;
import com.tms.springboot.model.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MethodsForWorkWithDatabase {

    @Autowired
    private SessionFactory factory;


    public void saveCar(List<Car> cars) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Car car : cars) {
            session.save(car);
        }
        transaction.commit();
        session.close();

    }

    public void saveRegion(List<Region> regions){

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Region region : regions) {
            session.save(region);
        }
        transaction.commit();
        session.close();

    }

    public void saveClients(List<Client> clients){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Client client : clients) {
            session.save(client);
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

    public List<ClientDto> getAllData(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ClientDto> clientsFromDB = new ArrayList<>();
        List<Car> cars = session.createQuery("select distinct a from Car a left join fetch a.regions").list();
        List<Client> clients = session.createQuery("select distinct a from Client a join fetch a.cars t where a in :cars").setParameter("cars", cars).list();
        for (Client client : clients){
                ClientDto clientDto = new ClientDto();
                clientDto.setName(client.getName());
                List<CarDto> carsFromDB = new ArrayList<>();
                for (Car car : client.getCars()){
                    CarDto carDto = new CarDto(car.getNumber(), car.getRegions());
                    carsFromDB.add(carDto);
                }
                clientDto.setCars(carsFromDB);
                clientsFromDB.add(clientDto);
        }
        transaction.commit();
        session.close();
        return clientsFromDB;
    }

}
