package rw.rra.tracking.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rra.tracking.vehicle.models.VehicleOwner;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleOwnerRepo extends JpaRepository<VehicleOwner, UUID> {
    Optional<VehicleOwner> findByNationalId(String nationalId);
    Optional<VehicleOwner> findByPhone(String phone);
    Optional<VehicleOwner> findByEmail(String email);
    Optional<VehicleOwner> findByFullNameContainingIgnoreCase(String name);
}

