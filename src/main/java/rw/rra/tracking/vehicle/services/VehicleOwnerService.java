package rw.rra.tracking.vehicle.services;

import rw.rra.tracking.vehicle.dto.VehicleOwnerDTO;
import rw.rra.tracking.vehicle.models.VehicleOwner;

import java.util.List;

public interface VehicleOwnerService {
    VehicleOwnerDTO registerOwner(VehicleOwnerDTO dto);
    List<VehicleOwner> getAllOwners();
    VehicleOwner getOwnerByNationalId(String nationalId);
    VehicleOwner getOwnerByPhone(String phone);
    VehicleOwner getOwnerByEmail(String email);
}

