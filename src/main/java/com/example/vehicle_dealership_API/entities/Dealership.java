package com.example.vehicle_dealership_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dealerships")
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealershipId;

    //Validation
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 150, message = "Name must be between 1 and 150")
    @Column(nullable = false, length = 150)
    private String name;

    @NotBlank(message = "Address is required")
    @Size(min = 1, max = 200, message = "Address must be between 1 and 200")
    @Column(nullable = false, length = 200)
    private String address;

    @NotBlank(message = "Phone")
    @Size(min = 1, max = 100, message = "Phone must be between 1 and 100")
    @Column(nullable = false, length = 100)
    private String phone;

    public Dealership(Long dealershipId, String name, String address, String phone) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Long getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(Long dealershipId) {
        this.dealershipId= dealershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
