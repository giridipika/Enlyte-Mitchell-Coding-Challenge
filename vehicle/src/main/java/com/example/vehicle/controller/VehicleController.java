package com.example.vehicle.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vehicle.model.Vehicle;

@RestController
public class VehicleController {
    @GetMapping("/vehicle")
    public Vehicle vehicle(
        @RequestParam(value = "id", defaultValue = "0") String id,
        @RequestParam(value = "year", defaultValue = "1950")String year,
        @RequestParam(value = "make", defaultValue = " ") String make,
        @RequestParam(value = "model", defaultValue = " ") String model
    ){
        return new Vehicle(Integer.parseInt(id), Integer.parseInt(id), make, model);
    }
    
}
