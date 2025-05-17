package rw.rra.tracking.vehicle.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class VehicleTransferDTO {
    private UUID vehicleId;
    private UUID newOwnerId;
    private UUID newPlateNumberId;
    private Long amount;
    private LocalDate transferDate;
}

