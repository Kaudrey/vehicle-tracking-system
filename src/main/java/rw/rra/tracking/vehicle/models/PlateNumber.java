package rw.rra.tracking.vehicle.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private LocalDate issuedDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private VehicleOwner owner;
}
