package rw.rra.tracking.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rra.tracking.vehicle.models.VehicleTransfer;

import java.util.List;
import java.util.UUID;

public interface VehicleTransferRepo extends JpaRepository<VehicleTransfer, UUID> {
    List<VehicleTransfer> findByVehicle_ChassisNumber(String chassisNumber);
    List<VehicleTransfer> findByVehicle_PlateNumber_PlateNumber(String plateNumber);
}

