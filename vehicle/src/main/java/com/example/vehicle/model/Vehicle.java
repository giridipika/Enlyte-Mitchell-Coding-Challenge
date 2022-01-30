package com.example.vehicle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {
    public @Id @GeneratedValue int id;
    // public @Id int id;

    @Min(value = 1950, message = "year cannot be less than 1950")
    @Max(value = 2050, message = "year cannot be greater than 2050")
    public int year;

    @NotNull(message = "make cannot be empty")
    public String make;
    
    @NotNull(message = "model cannot be empty")
    public String model;
    
    // getter and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    // default constructor
    Vehicle(){        
    }

    // parameterized constructor 
    public Vehicle(int id, int year, String make, String model){
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle\nId: " + id + "\nYear: "  + year + "\nMake: " 
                + make + "\nModel: " + model + "\n";
    }

    
}
