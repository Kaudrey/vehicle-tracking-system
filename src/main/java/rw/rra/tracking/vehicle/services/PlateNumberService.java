package rw.rra.tracking.vehicle.services;

import rw.rra.tracking.vehicle.dto.PlateNumberDTO;
import rw.rra.tracking.vehicle.models.PlateNumber;

import java.util.List;
import java.util.UUID;

public interface PlateNumberService {
    PlateNumberDTO registerPlate(PlateNumberDTO dto);
    List<PlateNumber> getPlatesByOwner(UUID ownerId);
}

