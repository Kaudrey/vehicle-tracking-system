package rw.rra.tracking.vehicle.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import rw.rra.tracking.vehicle.models.Vehicle;

import java.util.UUID;

public interface VehicleRepo extends JpaRepository<Vehicle, UUID> {

}

