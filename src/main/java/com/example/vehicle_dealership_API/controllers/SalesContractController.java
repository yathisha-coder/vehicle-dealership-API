package com.example.vehicle_dealership_API.controllers;

import com.example.vehicle_dealership_API.entities.SalesContract;
import com.example.vehicle_dealership_API.services.SalesContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salesContracts")
public class SalesContractController {
    private SalesContractService salesContractService;

    @Autowired
    public SalesContractController(SalesContractService salesContractService){
        this.salesContractService = salesContractService;
    }

    @GetMapping
    public ResponseEntity<List<SalesContract>> getAllSalesContracts(
            @RequestParam(value = "salesContractId", required = false)Long id
    ){
         List<SalesContract> salesContracts = salesContractService.getAllSalesContract();
         return ResponseEntity.ok(salesContracts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SalesContract> getSalesContractById(@PathVariable Long id) {

        Optional<SalesContract> salesContract = salesContractService.getSalesContractById(id);
        if (salesContract.isPresent()) {
            return new ResponseEntity<>(salesContract.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<SalesContract> create(@RequestBody @Valid SalesContract contract) {
        return new ResponseEntity<>(
                salesContractService.createSalesContract(contract),
                HttpStatus.CREATED
        );
    }
}
