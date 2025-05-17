package rw.rra.tracking.vehicle.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.rra.tracking.vehicle.dto.VehicleDTO;
import rw.rra.tracking.vehicle.models.Vehicle;
import rw.rra.tracking.vehicle.services.VehicleService;

import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    @Autowired
    private final VehicleService vehicleService;

    @PostMapping("/register")
    public ResponseEntity<Vehicle> register(@RequestBody VehicleDTO dto) {
        return ResponseEntity.ok(vehicleService.registerVehicle(dto));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
}

