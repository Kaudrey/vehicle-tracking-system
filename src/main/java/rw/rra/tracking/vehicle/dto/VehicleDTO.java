package rw.rra.tracking.vehicle.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class VehicleDTO {
    private String chassisNumber;
    private String manufactureCompany;
    private int manufactureYear;
    private double price;
    private String modelName;
    private UUID ownerId;
    private UUID plateNumberId;
    private LocalDate registrationDate;
}

