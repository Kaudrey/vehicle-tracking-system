package rw.rra.tracking.vehicle.services;

import rw.rra.tracking.vehicle.dto.VehicleTransferDTO;
import rw.rra.tracking.vehicle.models.VehicleTransfer;

public interface VehicleTransferService {
    VehicleTransfer transferVehicle(VehicleTransferDTO dto);
}

