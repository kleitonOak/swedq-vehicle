package com.swedq.vehicle.dto;

import com.swedq.vehicle.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO implements Serializable {
    @NotEmpty
    @Size(min = 17, max = 17)
    private String idVehicle;
    @NotEmpty
    @Size(max = 17)
    private String registrationNumber;
    @NotNull
    private Integer idCustomer;
    private Status status;

    public VehicleDTO(Vehicle vehicle){
        this.idVehicle = vehicle.getId();
        this.registrationNumber = vehicle.getRegistrationNumber();
        this.idCustomer = vehicle.getIdCustomer();
        this.status = determineStatus(vehicle.getLastUpdate());
    }

    private Status determineStatus(Date lastUpdate) {
        Status currentStatus = Status.OFFLINE;
            if(lastUpdate != null && getMinutesDiff(lastUpdate) <= 1){
                currentStatus = Status.ONLINE;
            }
         return currentStatus;
    }

    private static long getMinutesDiff(Date lastUpdate){
            long diff = new Date().getTime() - lastUpdate.getTime();
            return (diff / (60 * 1000) % 60);
    }

//    public static void main(String[] args) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String str = "2019-07-18 12:15:00";
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//        Date lastUpdate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.printf("Minutes: %d", getMinutesDiff(lastUpdate));
//    }

    public enum Status{
        ONLINE("Online"),
        OFFLINE("Offline");

        private String status;
        private Status(String status){
            this.status = status;
        }

    }
}
