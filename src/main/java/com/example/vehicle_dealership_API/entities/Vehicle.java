package com.example.vehicle_dealership_API.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    private String vin;

    //Validation
    @NotBlank(message = "Year is required")
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
    @NotBlank(message = "OdoMeter is required")
    @Positive(message = "OdoMeter must be a positive number")
    private Integer odoMeter;
    @NotBlank(message = "Color is required")
    @Size(min = 1, max = 100, message = "color must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String color;

    @PositiveOrZero(message = "Price cannot be negative")
    private double price;

    public Vehicle(){}

    public Vehicle(String vin, int year, String make, String model, String vehicleType, int odoMeter, String color, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.odoMeter = odoMeter;
        this.color = color;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(int odoMeter) {
        this.odoMeter = odoMeter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
