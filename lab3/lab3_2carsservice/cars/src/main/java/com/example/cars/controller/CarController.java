package com.example.cars.controller;

import com.example.cars.model.Car;
import com.example.cars.service.CarManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarManagerService carManagerService;

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carManagerService.save(car), HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId) {
        return ResponseEntity.of(carManagerService.getCarDetails(carId));
    }

}
