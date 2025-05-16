package rw.rra.tracking.vehicle.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PlateNumberDTO {
    private String plateNumber;
    private LocalDate issuedDate;
    private UUID ownerId;
}

