package com.carsandusers;

import com.carsandusers.entities.Car;
import com.carsandusers.entities.Owner;
import com.carsandusers.repositories.CarRepository;
import com.carsandusers.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class init implements CommandLineRunner {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public init(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (carRepository.count()==0){
            Owner owner1 = new Owner();
            owner1.setFirstName("Atanas");
            owner1.setLastName("Migarev");
            owner1.setTelephoneNumber("0945121554");
            owner1.setEmail("atanas@abv.bg");

            Owner owner2 = new Owner();
           owner2.setFirstName("Jivko");
           owner2.setLastName("KOstadinov");
           owner2.setTelephoneNumber("05165515");
           owner2.setEmail("jivko@abv.bg");

            Owner owner3 = new Owner();
            owner3.setFirstName("Ivan");
            owner3.setLastName("Darev");
            owner3.setTelephoneNumber("546523122");
            owner3.setEmail("dIvan@abv.bg");

            Owner owner4 = new Owner();
            owner4.setFirstName("Kosta");
            owner4.setLastName("Kirakiev");
            owner4.setTelephoneNumber("0552128996");
            owner4.setEmail("kostakis@abv.bg");

            Owner owner5 = new Owner();
           owner5.setFirstName("Pavel");
           owner5.setLastName("Arkadev");
           owner5.setTelephoneNumber("54654886541");
           owner5.setEmail("arkadev@abv.bg");

            Car car1 = new Car();
            car1.setOwner(owner1);
            car1.setBrand("Mercedes");
            car1.setModel("A300");
            car1.setRegistrationNumber("cs1256bv");
            car1.setColor("red");
            car1.setHp("79");

            Car car2 = new Car();
            car2.setOwner(owner2);
            car2.setBrand("Mercedes");
            car2.setModel("S500");
            car2.setRegistrationNumber("cc7812bv");
            car2.setColor("black");
            car2.setHp("240");

            Car car3 = new Car();
            car3.setOwner(owner3);
            car3.setBrand("Mercedes");
            car3.setModel("C180");
            car3.setRegistrationNumber("cs1224tv");
            car3.setColor("yellow");
            car3.setHp("120");

            Car car4 = new Car();
            car4.setOwner(owner4);
            car4.setBrand("BMW");
            car4.setModel("315");
            car4.setRegistrationNumber("ct1241vv");
            car4.setColor("red");
            car4.setHp("300");

            Car car5 = new Car();
            car5.setOwner(owner5);
            car5.setBrand("Volvo");
            car5.setModel("v451");
            car5.setRegistrationNumber("ts3216bv");
            car5.setColor("blue");
            car5.setHp("98");

//            ownerRepository.save(owner1);
//            ownerRepository.save(owner2);
//            ownerRepository.save(owner3);
//            ownerRepository.save(owner4);
//            ownerRepository.save(owner5);
//
//            carRepository.save(car1);
//            carRepository.save(car2);
//            carRepository.save(car3);
//            carRepository.save(car4);
//            carRepository.save(car5);

            ownerRepository.saveAll(List.of(owner1,owner2,owner3,owner4,owner5));
            carRepository.saveAll(List.of(car1,car2,car3,car4,car5));

        }
    }
}
