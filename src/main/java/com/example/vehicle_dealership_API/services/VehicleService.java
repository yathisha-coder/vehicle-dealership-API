package com.example.vehicle_dealership_API.services;

import com.example.vehicle_dealership_API.entities.Vehicle;
import com.example.vehicle_dealership_API.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;
    //Dependency Injection
    @Autowired
    private VehicleService(VehicleRepository vehicleRepository){this.vehicleRepository = vehicleRepository;}

    //Get All Vehicles
    public List<Vehicle> getAllVehicles(){
       // List<Vehicle> vehicleList = vehicleRepository.findAll();

        return vehicleRepository.findAll();
    }
    public List<Vehicle> searchVehicles(String vin,Double minPrice,
                                        Double maxPrice, String make, String model, String color,
                                        Integer minYear, Integer maxYear){
        if(vin !=null){
        return vehicleRepository.findByVinContainingIgnoreCase(vin);
        }
        if (minPrice != null && maxPrice != null) {
            return vehicleRepository.findByPriceBetween(minPrice, maxPrice);
        }
        if(make != null){
            return vehicleRepository.findByMakeContainingIgnoreCase(make);
        }
        if(model != null){
            return vehicleRepository.findByModelContainingIgnoreCase(model);
        }
        if(color != null){
            return vehicleRepository.findByColorContainingIgnoreCase(color);
        }
        if(minYear != null && maxPrice!= null){
            return vehicleRepository.findByYearBetween(minYear,maxYear);
        }
        return vehicleRepository.findAll();
    }

}
