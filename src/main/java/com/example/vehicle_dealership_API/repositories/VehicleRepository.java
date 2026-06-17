package com.example.vehicle_dealership_API.repositories;

import com.example.vehicle_dealership_API.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    //derived query
    //SELECT * FROM vehicles WHERE LOWER(vin) LIKE '%LOWER(vin)%'
    List<Vehicle>findByVinContainingIgnoreCase(String vin);
    List<Vehicle>findByMakeContainingIgnoreCase(String make);
    List<Vehicle>findByModelContainingIgnoreCase(String model);
    List<Vehicle>findByColorContainingIgnoreCase(String color);
    List<Vehicle>findByYearBetween(Integer minYear,Integer maxYear);
    List<Vehicle>findByPriceBetween(double minPrice, double maxPrice);
}
