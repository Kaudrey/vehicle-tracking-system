package rw.rra.tracking.vehicle.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
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
    private VehicleOwner owner;

    @ManyToOne
    private PlateNumber plateNumber;

    private LocalDate registrationDate;
}

