package rw.rra.tracking.vehicle.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.rra.tracking.vehicle.dto.PlateNumberDTO;
import rw.rra.tracking.vehicle.models.PlateNumber;
import rw.rra.tracking.vehicle.services.PlateNumberService;

import java.util.List;
import java.util.UUID;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/plates")

public class PlateNumberController {

    private final PlateNumberService plateNumberService;

    @PostMapping("/register")
    public ResponseEntity<PlateNumberDTO> registerPlate(@RequestBody PlateNumberDTO dto) {
        return ResponseEntity.ok(plateNumberService.registerPlate(dto));
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<List<PlateNumber>> getPlatesByOwner(@PathVariable UUID ownerId) {
        return ResponseEntity.ok(plateNumberService.getPlatesByOwner(ownerId));
    }
}

