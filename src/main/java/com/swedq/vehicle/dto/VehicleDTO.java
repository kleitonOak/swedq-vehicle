package com.swedq.vehicle.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VehicleDTO implements Serializable {
    private String id;
    private String registrationNumber;
    private Integer idCustomer;
    private Status status;

    public enum Status{
        ONLINE("Online"),
        OFFLINE("Offline");

        private String status;
        private Status(String status){
            this.status = status;
        }

    }
}
