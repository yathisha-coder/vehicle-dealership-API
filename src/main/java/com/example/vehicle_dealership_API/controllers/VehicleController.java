package com.example.vehicle_dealership_API.controllers;


import com.example.vehicle_dealership_API.entities.Vehicle;
import com.example.vehicle_dealership_API.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return  ResponseEntity.ok(vehicles);
    }
}
