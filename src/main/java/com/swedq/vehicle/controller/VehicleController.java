package com.swedq.vehicle.controller;

import com.swedq.vehicle.dto.VehicleDTO;
import com.swedq.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/vehicle", headers = "Accept=application/json")
public class VehicleController {

    @Autowired
    VehicleService service;

    @PutMapping
    public ResponseEntity<Void> createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
        service.save(vehicleDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getCustomer(@PathVariable String id){
        VehicleDTO vehicleDTO = service.find(id);
        if(vehicleDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<VehicleDTO> getCustomer(@PathVariable Integer id){
        VehicleDTO vehicleDTO = service.find(id);
        if(vehicleDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(vehicleDTO);
    }
}
