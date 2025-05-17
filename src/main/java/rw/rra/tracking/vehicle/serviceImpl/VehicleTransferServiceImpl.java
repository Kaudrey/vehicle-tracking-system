package rw.rra.tracking.vehicle.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.rra.tracking.vehicle.dto.VehicleTransferDTO;
import rw.rra.tracking.vehicle.models.PlateNumber;
import rw.rra.tracking.vehicle.models.Vehicle;
import rw.rra.tracking.vehicle.models.VehicleOwner;
import rw.rra.tracking.vehicle.models.VehicleTransfer;
import rw.rra.tracking.vehicle.repositories.PlateNumberRepo;
import rw.rra.tracking.vehicle.repositories.VehicleOwnerRepo;
import rw.rra.tracking.vehicle.repositories.VehicleRepo;
import rw.rra.tracking.vehicle.repositories.VehicleTransferRepo;
import rw.rra.tracking.vehicle.services.VehicleTransferService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleTransferServiceImpl implements VehicleTransferService {

    private final VehicleRepo vehicleRepo;
    private final VehicleOwnerRepo ownerRepo;
    private final PlateNumberRepo plateRepo;
    private final VehicleTransferRepo transferRepo;

    @Override
    @Transactional
    public VehicleTransfer transferVehicle(VehicleTransferDTO dto) {
        Vehicle vehicle = vehicleRepo.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + dto.getVehicleId()));

        VehicleOwner newOwner = ownerRepo.findById(dto.getNewOwnerId())
                .orElseThrow(() -> new RuntimeException("New owner not found with ID: " + dto.getNewOwnerId()));

        PlateNumber newPlate = plateRepo.findById(dto.getNewPlateNumberId())
                .orElseThrow(() -> new RuntimeException("Plate number not found with ID: " + dto.getNewPlateNumberId()));

        if (newPlate.isInUse()) {
            throw new RuntimeException("Plate " + newPlate.getPlateNumber() + " is already in use!");
        }

        // Handle current owner and plate
        PlateNumber oldPlate = vehicle.getPlateNumber();
        if (oldPlate != null) {
            oldPlate.setInUse(false);
            plateRepo.save(oldPlate);
        }

        // Assign new plate
        newPlate.setInUse(true);
        plateRepo.save(newPlate);
        vehicle.setPlateNumber(newPlate);

        // Update owner
        VehicleOwner oldOwner = vehicle.getCurrentOwner();
        vehicle.setCurrentOwner(newOwner);
        vehicleRepo.save(vehicle);

        // Save transfer history
        VehicleTransfer transfer = new VehicleTransfer();
        transfer.setVehicle(vehicle);
        transfer.setFromOwner(oldOwner); // this can be null if first transfer
        transfer.setToOwner(newOwner);
        transfer.setAmount(dto.getAmount());
        transfer.setTransferDate(dto.getTransferDate());

        return transferRepo.save(transfer);
    }
}
