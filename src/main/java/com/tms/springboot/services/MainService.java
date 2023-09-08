package com.tms.springboot.services;

import com.tms.springboot.dao.MethodsForWorkWithDatabase;
import com.tms.springboot.dto.ClientDto;
import com.tms.springboot.model.CARMODEL;
import com.tms.springboot.model.Car;
import com.tms.springboot.model.Client;
import com.tms.springboot.model.Region;
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
        List<Car> cars1 = new ArrayList<>();
        List<Car> cars2 = new ArrayList<>();
        List<Car> cars3 = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars1.add(car1);
        cars1.add(car2);
        cars2.add(car3);
        cars3.add(car4);
        Region region1 = new Region("Minsk");
        Region region2 = new Region("Brest");
        Region region3 = new Region("Vitebsk");
        Region region4 = new Region("Mogilev");
        Region region5 = new Region("Grodno");
        List<Region> regions = new ArrayList<>();
        regions.add(region1);
        regions.add(region2);
        regions.add(region3);
        regions.add(region4);
        regions.add(region5);
        Client client1 = new Client("Andrew");
        Client client2 = new Client("Mihail");
        Client client3 = new Client("Olga");
        Client client4 = new Client("Anastasia");
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        List<Client> clients1 = new ArrayList<>();
        List<Client> clients2 = new ArrayList<>();
        List<Client> clients3 = new ArrayList<>();
        clients1.add(client1);
        clients1.add(client2);
        clients2.add(client3);
        clients3.add(client4);
        client1.setCars(cars1);
        client2.setCars(cars2);
        client3.setCars(cars3);
        region1.setCars(cars1);
        region2.setCars(cars2);
        region4.setCars(cars3);

            repository.saveCar(cars);
            repository.saveClients(clients);
            repository.saveRegion(regions);

            List<ClientDto> clientsFromDB = repository.getAllData();
            for (ClientDto client : clientsFromDB){
                System.out.println(client);
            }
    }

}
