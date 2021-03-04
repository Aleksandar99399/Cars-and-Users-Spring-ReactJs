package com.carsandusers.services.impl;

import com.carsandusers.dto.CarDto;
import com.carsandusers.entities.Car;
import com.carsandusers.entities.Owner;
import com.carsandusers.repositories.CarRepository;
import com.carsandusers.services.CarService;
import com.carsandusers.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final OwnerService ownerService;



    @Autowired
    public CarServiceImpl(CarRepository carRepository, OwnerService ownerService) {
        this.carRepository = carRepository;
        this.ownerService = ownerService;
    }

    @Override
    public Car create(CarDto car) {

        Car newCar = new Car();
        newCar.setColor(car.getColor());
        newCar.setHp(car.getHp());
        newCar.setRegistrationNumber(car.getRegistrationNumber());
        newCar.setBrand(car.getBrand().toUpperCase()).setModel(car.getModel());
        newCar.setOwner(car.getOwner());




        Owner owner = ownerService.createOwner(car.getOwner());

        newCar.setOwner(owner);


        this.carRepository.save(newCar);
        return newCar;
    }

    @Override
    public List<Car> getAllCars() {

        return this.carRepository.findAll();
    }

    @Override
    public boolean deleteCar(Long id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isEmpty()){
            return false;
        }
        this.carRepository.deleteById(id);
        return true;
    }

    @Override
    public Car updateCar(Long id, CarDto carDto) {
        Car car = carRepository.getOne(id);

        if (carDto.getRegistrationNumber()!=null){
            car.setRegistrationNumber(carDto.getRegistrationNumber());
        }

        if (carDto.getColor()!=null){
            car.setColor(carDto.getColor());
        }

        if (carDto.getHp()!=null){
            car.setHp(carDto.getHp());
        }

        if (carDto.getBrand()!=null){
            car.setBrand(carDto.getBrand());
        }

        if (carDto.getModel()!=null){
            car.setModel(carDto.getModel());
        }

        if (carDto.getOwner()!=null){
            if (ownerService.getOwner(carDto.getOwner().getEmail())!=null){
                car.setOwner(ownerService.getOwner(carDto.getOwner().getEmail()));
            }else {
                Owner owner = car.getOwner();

                if (carDto.getOwner().getEmail() != null) {
                    owner.setEmail(carDto.getOwner().getEmail());
                }

                if (carDto.getOwner().getFirstName() != null) {
                    owner.setFirstName(carDto.getOwner().getFirstName());
                }

                if (carDto.getOwner().getLastName() != null) {
                    owner.setLastName(carDto.getOwner().getLastName());
                }

                if (carDto.getOwner().getTelephoneNumber() != null) {
                    owner.setTelephoneNumber(carDto.getOwner().getTelephoneNumber());
                }

                this.ownerService.save(owner);
                car.setOwner(owner);
            }
        }

        this.carRepository.save(car);

        return car;
    }

    @Override
    public List<Car> findAllByParams(String param) {
        List<Car> allByBrand = carRepository.findAllByBrand(param);

        return allByBrand;
    }

    @Override
    public Optional<Car> getById(Long id) {
        return this.carRepository.findById(id);
    }


}
