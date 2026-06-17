package com.example.vehicle_dealership_API.repositories;

import com.example.vehicle_dealership_API.entities.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, Long>{
    List<Dealership>findByDealershipId(Long dealershipId);
}
