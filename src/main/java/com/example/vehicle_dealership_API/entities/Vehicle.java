package com.example.vehicle_dealership_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @NotBlank(message = "Vin is required")
    private String vin;

    //Validation
    @NotNull(message = "Year is required")
    @Positive(message = "Year must be a positive number")
    private Integer year;

    @NotBlank(message = "Make is required")
    @Size(min = 1, max = 100, message = "Make must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String make;

    @NotBlank(message = "Model is required")
    @Size(min = 1, max = 100, message = "Model must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String model;

    @NotBlank(message = "VehicleType is required")
    @Size(min = 1, max = 100, message = "VehicleType must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String vehicleType;

    @NotNull(message = "OdoMeter is required")
    @Positive(message = "OdoMeter must be a positive number")
    private Integer odoMeter;

    @NotBlank(message = "Color is required")
    @Size(min = 1, max = 100, message = "color must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String color;

    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;

    public Vehicle(){}

    public Vehicle(String vin, Integer year, String make, String model,
                   String vehicleType, Integer odoMeter, String color,
                   Double price, Dealership dealership) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.odoMeter = odoMeter;
        this.color = color;
        this.price = price;
        this.dealership = dealership;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(Integer odoMeter) {
        this.odoMeter = odoMeter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }
}
