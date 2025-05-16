package rw.rra.tracking.vehicle.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.rra.tracking.vehicle.dto.VehicleOwnerDTO;
import rw.rra.tracking.vehicle.models.VehicleOwner;
import rw.rra.tracking.vehicle.repositories.VehicleOwnerRepo;
import rw.rra.tracking.vehicle.services.VehicleOwnerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleOwnerServiceImpl implements VehicleOwnerService {

    private final VehicleOwnerRepo vehicleOwnerRepo;

    @Override
    public VehicleOwnerDTO registerOwner(VehicleOwnerDTO dto) {
        VehicleOwner owner = new VehicleOwner();
        owner.setFullName(dto.getFullName());
        owner.setEmail(dto.getEmail());
        owner.setNationalId(dto.getNationalId());
        owner.setPhone(dto.getPhone());
        owner.setAddress(dto.getAddress());
        vehicleOwnerRepo.save(owner);
        return dto;
    }

    @Override
    public List<VehicleOwner> getAllOwners() {
        return vehicleOwnerRepo.findAll();
    }

    @Override
    public VehicleOwner getOwnerByNationalId(String nationalId) {
        return vehicleOwnerRepo.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    @Override
    public VehicleOwner getOwnerByPhone(String phone) {
        return vehicleOwnerRepo.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    @Override
    public VehicleOwner getOwnerByEmail(String email) {
        return vehicleOwnerRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }
}

