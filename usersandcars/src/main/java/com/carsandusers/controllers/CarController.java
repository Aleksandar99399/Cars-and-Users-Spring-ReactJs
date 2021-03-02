package com.carsandusers.controllers;

import com.carsandusers.dto.CarDto;
import com.carsandusers.entities.Car;
import com.carsandusers.error.ApiError;
import com.carsandusers.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping("/create")
    public ResponseEntity<Object> createCar(@RequestBody CarDto car, HttpServletResponse response) {

        if (car.getOwner() == null || car.getBrand() == null || car.getModel() == null) {
            return new ResponseEntity<Object>(new ApiError("Owner - all fields, Brand and Model are required in RequestBody"),
                    HttpStatus.BAD_REQUEST);
        }


        Car newCar = carService.create(car);

        return new ResponseEntity<Object>(newCar, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCars() {
        List<Car> cars = carService.getAllCars();

        if (cars.isEmpty()) {
            return new ResponseEntity<>(new ApiError("Not have cars for view"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
        if (!carService.deleteCar(id)) {
            return new ResponseEntity<>(new ApiError("Car is not exist"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {

        if (carService.getById(id).isEmpty()) {
            return new ResponseEntity<>(new ApiError("No such car with this ID"), HttpStatus.OK);
        }

        Car car = carService.updateCar(id, carDto);

        return new ResponseEntity<>(car, HttpStatus.OK);

    }

    @GetMapping("/all/params")
    public ResponseEntity<Object> getAllParam(@RequestParam(name = "model") String param) {
        List<Car> allByParams = carService.findAllByParams(param);

        if (allByParams.isEmpty()) {
            return new ResponseEntity<>(new ApiError("No such cars with this parameter in DB"), HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(allByParams, HttpStatus.OK);
    }


}
