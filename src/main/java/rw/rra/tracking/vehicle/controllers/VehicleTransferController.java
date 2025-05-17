package rw.rra.tracking.vehicle.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rra.tracking.vehicle.dto.VehicleTransferDTO;
import rw.rra.tracking.vehicle.models.VehicleTransfer;
import rw.rra.tracking.vehicle.services.VehicleTransferService;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class VehicleTransferController {
    private final VehicleTransferService transferService;

    @PostMapping
    public ResponseEntity<?> transfer(@RequestBody VehicleTransferDTO dto) {
        try {
            return ResponseEntity.ok(transferService.transferVehicle(dto));
        } catch (Exception e) {
            e.printStackTrace(); // or log it
            return ResponseEntity.badRequest().body("Transfer failed: " + e.getMessage());
        }
    }

}

