package com.example.vehicle_dealership_API.controllers;


import com.example.vehicle_dealership_API.entities.Vehicle;
import com.example.vehicle_dealership_API.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")//endpoint
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){this.vehicleService = vehicleService;}

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(
            @RequestParam(value = "vin", required = false) String vin,
            @RequestParam(value = "minPrice", required = false)Double minPrice,
            @RequestParam(value = "maxPrice", required = false)Double maxPrice,
            @RequestParam(value = "make", required = false)String make,
            @RequestParam(value = "model", required = false)String model,
            @RequestParam(value = "color", required = false)String color,
            @RequestParam(value = "minYear", required = false)Integer minYear,
            @RequestParam(value = "maxYear", required = false)Integer maxYear
    ){
        List<Vehicle> vehicles = vehicleService.searchVehicles(vin,minPrice,
                maxPrice,make,model,color,minYear,maxYear);
        if(vehicles.isEmpty()){
            return new ResponseEntity<>(vehicles,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody @Valid Vehicle vehicle){
        Vehicle newVehicle = this.vehicleService.create(vehicle);
        return  new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{vin}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody @Valid Vehicle vehicle,
                                                 @PathVariable String vin){
        Vehicle updatedVehicle = this.vehicleService.update(vin, vehicle);
        if(updatedVehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{vin}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String vin){
        boolean deleteSuccessful = this.vehicleService.delete(vin);
        if(!deleteSuccessful){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
