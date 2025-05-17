package rw.rra.tracking.vehicle.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String chassisNumber;

    @Column(nullable = false)
    private String manufactureCompany;

    @Column(nullable = false)
    private int manufactureYear;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "current_owner_id")
    private VehicleOwner currentOwner;

    @ManyToOne
    @JoinColumn(name = "plate_number_id")
    private PlateNumber plateNumber;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<VehicleTransfer> transfers;

    private LocalDate registrationDate;
}

