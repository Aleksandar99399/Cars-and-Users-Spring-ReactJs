package com.carsandusers.controllers;

import com.carsandusers.dto.CarDto;
import com.carsandusers.entities.Car;
import com.carsandusers.error.ApiError;
import com.carsandusers.services.CarService;
import com.carsandusers.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarController {

    private final CarService carService;
    private final OwnerService ownerService;

    @Autowired
    public CarController(CarService carService, OwnerService ownerService) {
        this.carService = carService;
        this.ownerService = ownerService;
    }


    @PostMapping("/create")
    public ResponseEntity<Object> createCar(@RequestBody CarDto car) {

        if (!ownerService.requiredOwner(car.getOwner())){
            return new ResponseEntity<>(
                    new ApiError("All fields on Owner are required"),
                    HttpStatus.BAD_REQUEST);
        }

        if (car.getBrand() == null || car.getModel() == null || car.getRegistrationNumber() ==null
            || car.getColor() ==null || car.getHp() == null) {
            return new ResponseEntity<>(
                    new ApiError("All fields for Car are required!"),
                    HttpStatus.BAD_REQUEST);
        }


        Car newCar = carService.create(car);

        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

//    @GetMapping("/")
//    public ResponseEntity<Object> getAllCars() {
//        List<Car> cars = carService.getAllCars();
//
//        if (cars.isEmpty()) {
//            return new ResponseEntity<>(new ApiError("Not have cars for view"), HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(cars, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
        if (!carService.deleteCar(id)) {
            return new ResponseEntity<>(new ApiError("Car is not exist"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {


        if (carService.getById(id).isEmpty()) {
            return new ResponseEntity<>(new ApiError("No such car with this ID"), HttpStatus.NOT_FOUND);
        }

        Car car = carService.updateCar(id, carDto);

        return new ResponseEntity<>(car, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllParam(@RequestParam(required = false) Map<String,String> str) {

        if (str.size() == 0){
            List<Car> cars = carService.getAllCars();

            if (cars.isEmpty()) {
                return new ResponseEntity<>(new ApiError("Not have cars for view"), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(cars, HttpStatus.OK);
        }

        List<Car> allByParams = new ArrayList<>();
        if (str.containsKey("brand")){
            allByParams = carService.findAllByParams(str.get("brand"));
        }


        if (allByParams.isEmpty()) {
            return new ResponseEntity<>(new ApiError("No such cars with this parameter in DB"), HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(allByParams, HttpStatus.OK);
    }


}
