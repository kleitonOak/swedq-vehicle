package com.swedq.vehicle.controller;

import com.swedq.vehicle.dto.VehicleDTO;
import com.swedq.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/vehicle", headers = "Accept=application/json")
public class VehicleController {

    @Autowired
    VehicleService service;

    @PostMapping
    public ResponseEntity<Void> createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
        service.save(vehicleDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        List<VehicleDTO> vehicleList = service.findAll();
        if(CollectionUtils.isEmpty(vehicleList)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(vehicleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable String id){
        VehicleDTO vehicleDTO = service.find(id);
        if(vehicleDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Integer id){
        VehicleDTO vehicleDTO = service.find(id);
        if(vehicleDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(vehicleDTO);
    }
}
