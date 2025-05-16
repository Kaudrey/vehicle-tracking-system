package rw.rra.tracking.vehicle.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.rra.tracking.vehicle.dto.PlateNumberDTO;
import rw.rra.tracking.vehicle.models.PlateNumber;
import rw.rra.tracking.vehicle.models.VehicleOwner;
import rw.rra.tracking.vehicle.repositories.PlateNumberRepo;
import rw.rra.tracking.vehicle.repositories.VehicleOwnerRepo;
import rw.rra.tracking.vehicle.services.PlateNumberService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlateNumberServiceImpl implements PlateNumberService {

    private final PlateNumberRepo plateNumberRepo;
    private final VehicleOwnerRepo vehicleOwnerRepo;

    @Override
    public PlateNumberDTO registerPlate(PlateNumberDTO dto) {
        VehicleOwner owner = vehicleOwnerRepo.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        PlateNumber plate = new PlateNumber();
        plate.setPlateNumber(dto.getPlateNumber());
        plate.setIssuedDate(dto.getIssuedDate());
        plate.setOwner(owner);

        plateNumberRepo.save(plate);
        return dto;
    }

    @Override
    public List<PlateNumber> getPlatesByOwner(UUID ownerId) {
        return plateNumberRepo.findByOwnerId(ownerId);
    }
}
