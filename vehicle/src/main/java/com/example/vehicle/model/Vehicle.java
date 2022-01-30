package com.example.vehicle.model;

public class Vehicle{
    public int id;
    public int year;
    public String make;
    public String model;

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
    
    public Vehicle(int id1, int year1, String make1, String model1){
        id = id1;
        year = year1;
        make = make1;
        model = model1;
    }
}