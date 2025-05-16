package rw.rra.tracking.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rra.tracking.vehicle.models.PlateNumber;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlateNumberRepo extends JpaRepository<PlateNumber, UUID> {
    List<PlateNumber> findByOwnerId(UUID ownerId);
}

