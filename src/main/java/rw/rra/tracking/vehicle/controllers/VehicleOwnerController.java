package rw.rra.tracking.vehicle.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.rra.tracking.vehicle.dto.VehicleOwnerDTO;
import rw.rra.tracking.vehicle.models.VehicleOwner;
import rw.rra.tracking.vehicle.services.VehicleOwnerService;

import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class VehicleOwnerController {

    private final VehicleOwnerService vehicleOwnerService;

    @PostMapping("/register")
    public ResponseEntity<VehicleOwnerDTO> registerOwner(@RequestBody VehicleOwnerDTO dto) {
        return ResponseEntity.ok(vehicleOwnerService.registerOwner(dto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleOwner>> getAllOwners() {
        return ResponseEntity.ok(vehicleOwnerService.getAllOwners());
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String key) {
        try {
            return ResponseEntity.ok(vehicleOwnerService.getOwnerByNationalId(key));
        } catch (Exception ignored1) {
        }

        try {
            return ResponseEntity.ok(vehicleOwnerService.getOwnerByPhone(key));
        } catch (Exception ignored2) {
        }

        try {
            return ResponseEntity.ok(vehicleOwnerService.getOwnerByEmail(key));
        } catch (Exception ignored3) {
        }

        return ResponseEntity.status(404).body("Owner not found");
    }
}

