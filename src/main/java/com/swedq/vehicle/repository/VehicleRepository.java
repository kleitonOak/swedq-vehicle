package com.swedq.vehicle.repository;

import com.swedq.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    public Optional<Vehicle> findByIdCustomer(Integer idCustomer);
}
