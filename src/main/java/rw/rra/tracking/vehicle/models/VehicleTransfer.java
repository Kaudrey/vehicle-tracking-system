package rw.rra.tracking.vehicle.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class VehicleTransfer {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private VehicleOwner fromOwner;

    @ManyToOne
    private VehicleOwner toOwner;

    private Long amount;

    private LocalDate transferDate;
}

