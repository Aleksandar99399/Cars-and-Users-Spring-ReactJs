package com.carsandusers.repositories;

import com.carsandusers.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

//    @Query("SELECT  FROM ")
    List<Car> findAllByBrand(String brand);
}
