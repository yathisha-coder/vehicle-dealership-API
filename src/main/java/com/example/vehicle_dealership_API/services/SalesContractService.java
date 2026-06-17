package com.example.vehicle_dealership_API.services;

import com.example.vehicle_dealership_API.controllers.SalesContractController;
import com.example.vehicle_dealership_API.entities.Dealership;
import com.example.vehicle_dealership_API.entities.SalesContract;
import com.example.vehicle_dealership_API.entities.Vehicle;
import com.example.vehicle_dealership_API.repositories.DealershipRepository;
import com.example.vehicle_dealership_API.repositories.SalesContractRepository;
import com.example.vehicle_dealership_API.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesContractService {
    private SalesContractRepository salesContractRepository;
    private VehicleRepository vehicleRepository;
    private DealershipRepository dealershipRepository;
    @Autowired
    private SalesContractService(SalesContractRepository salesContractRepository,
                                 VehicleRepository vehicleRepository,
                                 DealershipRepository dealershipRepository){
        this.salesContractRepository = salesContractRepository;
        this.vehicleRepository = vehicleRepository;
        this.dealershipRepository = dealershipRepository;
    }

    public List<SalesContract> getAllSalesContract(){
        List<SalesContract> salesContractList = salesContractRepository.findAll();

        return salesContractList;
    }
    public Optional<SalesContract> getSalesContractById(Long id){
        var salesContact = salesContractRepository.findById(id);
        return salesContact;
    }
    public SalesContract createSalesContract(SalesContract salesContract) {
        Vehicle vehicle = vehicleRepository.findById(salesContract.getVehicle().getVin()
        ).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        salesContract.setVehicle(vehicle);

        Dealership dealership = dealershipRepository.findById(
                salesContract.getDealership().getDealershipId()
        ).orElseThrow(() -> new RuntimeException("Dealership not found"));
        salesContract.setDealership(dealership);

        return salesContractRepository.save(salesContract);
    }
}
