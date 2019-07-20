package com.swedq.vehicle.service;

import com.swedq.vehicle.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    public void save(VehicleDTO vehicleDTO);
    public VehicleDTO find(String vehicleId);
    public VehicleDTO find(Integer customerId);
    public List<VehicleDTO> findAll();
}
