package com.WarrantyTrackingApplication.demo.Warranty.controller;

import com.WarrantyTrackingApplication.demo.Warranty.service.concretes.WarrantyService;
import com.WarrantyTrackingApplication.demo.Warranty.model.entity.Warranty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("warranty")
@RequiredArgsConstructor
public class WarrantyController {

    @Autowired
    private WarrantyService warrantyService;

    // Update the status of a Warranty by ID
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateWarrantyStatus(@PathVariable Long id) {
        try {
            warrantyService.updateWarrantyStatus(id);
            return ResponseEntity.ok("Warranty status updated.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Warranty not found: " + e.getMessage());
        }
    }

    // Create a new Warranty
    @PostMapping
    public ResponseEntity<Warranty> createWarranty(@RequestBody Warranty warranty) {
        Warranty savedWarranty = warrantyService.saveWarranty(warranty);
        return ResponseEntity.ok(savedWarranty);
    }

    // Get a list of all Warranties
    @GetMapping
    public ResponseEntity<List<Warranty>> getAllWarranties() {
        return ResponseEntity.ok(warrantyService.getAllWarranties());
    }

    // Get a Warranty by ID
    @GetMapping("/{id}")
    public ResponseEntity<Warranty> getWarrantyById(@PathVariable Long id) {
        try {
            Warranty warranty = warrantyService.getWarrantyById(id);
            return ResponseEntity.ok(warranty);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
