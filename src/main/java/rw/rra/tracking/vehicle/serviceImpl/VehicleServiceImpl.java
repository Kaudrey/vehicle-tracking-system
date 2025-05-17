package rw.rra.tracking.vehicle.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.rra.tracking.vehicle.dto.VehicleDTO;
import rw.rra.tracking.vehicle.models.PlateNumber;
import rw.rra.tracking.vehicle.models.Vehicle;
import rw.rra.tracking.vehicle.models.VehicleOwner;
import rw.rra.tracking.vehicle.repositories.PlateNumberRepo;
import rw.rra.tracking.vehicle.repositories.VehicleOwnerRepo;
import rw.rra.tracking.vehicle.repositories.VehicleRepo;
import rw.rra.tracking.vehicle.services.VehicleService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;
    private final VehicleOwnerRepo ownerRepo;
    private final PlateNumberRepo plateNumberRepo;

    @Override
    public Vehicle registerVehicle(VehicleDTO dto) {
        VehicleOwner owner = ownerRepo.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        PlateNumber plate = plateNumberRepo.findById(dto.getPlateNumberId())
                .orElseThrow(() -> new RuntimeException("Plate number not found"));

        Vehicle vehicle = Vehicle.builder()
                .chassisNumber(dto.getChassisNumber())
                .manufactureCompany(dto.getManufactureCompany())
                .manufactureYear(dto.getManufactureYear())
                .price(dto.getPrice())
                .modelName(dto.getModelName())
                .owner(owner)
                .plateNumber(plate)
                .registrationDate(dto.getRegistrationDate())
                .build();

        return vehicleRepo.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }
}
