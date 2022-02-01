package com.example.vehicle.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository Interface inherits JPA Repo
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{    
    public Vehicle findByMake(String make);
    public Vehicle findByModel(String model);
}
