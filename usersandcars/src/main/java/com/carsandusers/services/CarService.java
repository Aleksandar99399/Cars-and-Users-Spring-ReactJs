package com.carsandusers.services;


import com.carsandusers.dto.CarDto;
import com.carsandusers.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car create(CarDto car);

    List<Car> getAllCars();

    boolean deleteCar(Long id);

    Car updateCar(Long id, CarDto carDto);

    List<Car> findAllByParams(String param);

    Optional<Car> getById(Long id);


}
