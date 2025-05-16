package rw.rra.tracking.vehicle.dto;

import lombok.Data;

@Data
public class VehicleOwnerDTO {
    private String fullName;
    private String nationalId;
    private String email;
    private String phone;
    private String address;
}

