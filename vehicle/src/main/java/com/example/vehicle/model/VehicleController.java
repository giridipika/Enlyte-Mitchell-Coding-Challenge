package com.example.vehicle.model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@Validated
public class VehicleController {
    private final VehicleRepository repository;

    //constructor
    VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    // create new Vehicle and save it to the database
    @PostMapping("/vehicles")
    public Vehicle createNewVehicles(
        @RequestParam(defaultValue = "0") int id, //allow unique id if empty
        @RequestParam @Min(1950) @Max(2050) int year,
        @RequestParam(value = "make") @NotBlank String make,
        @RequestParam(value = "model")@NotBlank String model
    ){
        Vehicle newVehicle = new Vehicle(id, year, make, model);
        return repository.save(newVehicle);
    }

    // replace or create vehicle
    @PutMapping("/vehicles")
    public Vehicle updateVehicle(
        @RequestParam int id,
        @RequestParam @Min(1950) @Max(2050) int year,
        @RequestParam(value = "make") @NotBlank String make,
        @RequestParam(value = "model") @NotBlank String model
    ){
        // find vehicle by Id
        return repository.findById(id).map(vehicle ->{
            vehicle.setYear(year);
            vehicle.setMake(make);
            vehicle.setModel(model);
            return repository.save(vehicle);
        }).orElseGet(()-> {
            // save a new vehicle
            Vehicle newVehicle = new Vehicle(id, year, make, model);
            return repository.save(newVehicle);
        });
    }

    // get all vehicle class object
    @GetMapping("/vehicles")
    List<Vehicle> readVehicles() {
        return repository.findAll();
    }
    // get vehicle with id
    @GetMapping("/vehicles/{id}")
    Optional<Vehicle> getVehicleById(@PathVariable int id) {
        return repository.findById(id);
    }
    // delete vehicle object with id
    @DeleteMapping("/vehicles/{id}")
    void deleteVehicle(@PathVariable int id) {
        repository.deleteById(id);
    }

    //get all vehicle with make:toyota
    // @GetMapping("/vehicle")
    // List<Vehicle> readVehicleByMake(
    //     @RequestParam(value = "make") String make
    // ) {
    //     return repository.findByMake(make);
    // }

    

    

}
