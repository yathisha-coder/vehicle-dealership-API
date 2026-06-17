package com.example.vehicle_dealership_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "salesContracts")
public class SalesContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesContractId;

    @NotBlank(message ="Customer Name is required")
    @Size(min = 1, max = 100, message ="Customer Name must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String customerName;

    @NotNull(message = "Sale date is required")
    private LocalDate saleDate;

    @PositiveOrZero(message = "Price cannot be negative")
    private Double salePrice;

    @ManyToOne
    @JoinColumn(name = "vin")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "dealershipId")
    private Dealership dealership;

    public SalesContract(){
    }

    public SalesContract(Long salesContractId, String customerName, LocalDate saleDate, Double salePrice, Vehicle vehicle, Dealership dealership) {
        this.salesContractId = salesContractId;
        this.customerName = customerName;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.vehicle = vehicle;
        this.dealership = dealership;
    }

    public Long getSalesContractId() {
        return salesContractId;
    }

    public void setSalesContractId(Long salesContractId) {
        this.salesContractId = salesContractId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }
}
