package com.swedq.vehicle.service;

import com.swedq.vehicle.dto.VehicleDTO;

public interface VehicleService {

    public void save(VehicleDTO vehicleDTO);
    public VehicleDTO find(String vehicleId);
    public VehicleDTO find(Integer customerId);
}
