package com.swedq.vehicle.service;

import com.swedq.vehicle.dto.VehicleDTO;
import com.swedq.vehicle.entity.Vehicle;
import com.swedq.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository repository;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        repository.save(new Vehicle(vehicleDTO));
    }

    @Override
    public VehicleDTO find(String vehicleId) {
        Optional<Vehicle> vehicleOptional = repository.findById(vehicleId);
        VehicleDTO dto = null;
        if(vehicleOptional.isPresent()){
            dto = new VehicleDTO(vehicleOptional.get());
        }
        return dto;
    }

    @Override
    public VehicleDTO find(Integer customerId) {

        Optional<Vehicle> vehicleOptional = repository.findByIdCustomer(customerId);
        VehicleDTO dto = null;
        if(vehicleOptional.isPresent()){
            dto = new VehicleDTO(vehicleOptional.get());
        }
        return dto;
    }
}
