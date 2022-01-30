package com.example.vehicle.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository Interface inherits JPA Repo
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{    
    List<Vehicle> findByMake(String make);
}
