package rw.rra.tracking.vehicle.services;

import rw.rra.tracking.vehicle.dto.VehicleDTO;
import rw.rra.tracking.vehicle.models.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle registerVehicle(VehicleDTO dto);
    List<Vehicle> getAllVehicles();
}
