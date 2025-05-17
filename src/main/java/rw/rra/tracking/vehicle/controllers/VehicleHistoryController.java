package rw.rra.tracking.vehicle.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rra.tracking.vehicle.models.VehicleTransfer;
import rw.rra.tracking.vehicle.repositories.VehicleTransferRepo;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/history")
@RequiredArgsConstructor
public class VehicleHistoryController {
    private final VehicleTransferRepo transferRepo;

    @GetMapping("/chassis/{chassisNumber}")
    public ResponseEntity<List<VehicleTransfer>> getHistoryByChassis(@PathVariable String chassisNumber) {
        return ResponseEntity.ok(transferRepo.findByVehicle_ChassisNumber(chassisNumber));
    }

    @GetMapping("/plate/{plateNumber}")
    public ResponseEntity<List<VehicleTransfer>> getHistoryByPlate(@PathVariable String plateNumber) {
        return ResponseEntity.ok(transferRepo.findByVehicle_PlateNumber_PlateNumber(plateNumber));
    }
}

