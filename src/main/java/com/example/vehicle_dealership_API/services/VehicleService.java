package com.example.vehicle_dealership_API.services;

import com.example.vehicle_dealership_API.entities.Vehicle;
import com.example.vehicle_dealership_API.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        if(minYear != null && maxYear!= null){
            return vehicleRepository.findByYearBetween(minYear,maxYear);
        }
        return vehicleRepository.findAll();
    }
    public Vehicle create(Vehicle vehicle){
        Vehicle newVehicle = vehicleRepository.save(vehicle);
        return newVehicle;
    }
    public Vehicle update(String vin, Vehicle vehicle){
        Optional<Vehicle> updateVehicle = vehicleRepository.findById(vin);
        if(updateVehicle.isEmpty()){
            return null;
        }
        Vehicle vehicleToUpdate = updateVehicle.get();

        vehicleToUpdate.setMake(vehicle.getMake());
        vehicleToUpdate.setModel(vehicle.getModel());
        vehicleToUpdate.setColor(vehicle.getColor());
        vehicleToUpdate.setVehicleType(vehicle.getVehicleType());
        vehicleToUpdate.setPrice(vehicle.getPrice());
        vehicleToUpdate.setYear(vehicle.getYear());
        vehicleToUpdate.setOdoMeter(vehicle.getOdoMeter());

        vehicleRepository.save(vehicleToUpdate);
        return vehicleToUpdate;
    }
    public boolean delete(String vin){
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findById(vin);
        if(vehicleToDelete.isEmpty()){
            return false;
        }
        vehicleRepository.delete(vehicleToDelete.get());
        return true;
    }
}
