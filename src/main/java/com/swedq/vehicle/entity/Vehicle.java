package com.swedq.vehicle.entity;

import com.swedq.vehicle.dto.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    @Column(name = "registration_number")
    private String registrationNumber;
    private Integer idCustomer;
    @Column(name = "last_update", insertable=false)
    private Date lastUpdate;

    public Vehicle(VehicleDTO vehicleDTO){
        this.id = vehicleDTO.getId();
        this.registrationNumber = vehicleDTO.getRegistrationNumber();
        this.idCustomer = vehicleDTO.getIdCustomer();
    }
}
