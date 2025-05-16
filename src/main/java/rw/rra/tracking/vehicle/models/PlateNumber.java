package rw.rra.tracking.vehicle.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plate_numbers")
public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private LocalDate issuedDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private VehicleOwner owner;
}
