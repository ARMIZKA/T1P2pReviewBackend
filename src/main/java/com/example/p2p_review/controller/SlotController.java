package com.example.p2p_review.controller;

import com.example.p2p_review.model.Slot;
import com.example.p2p_review.service.SlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
@Tag(name = "Slots", description = "API for managing booking slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("/available")
    @Operation(summary = "Get available slots", description = "Retrieve available slots for a specific expert")
    public ResponseEntity<List<Slot>> getAvailableSlots(@RequestParam Integer expertId) {
        List<Slot> slots = slotService.getAvailableSlots(expertId);
        return ResponseEntity.ok(slots);
    }

    @PostMapping
    @Operation(summary = "Create a new slot", description = "Create a new slot for an expert")
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
        Slot createdSlot = slotService.createSlot(slot);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSlot);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a slot", description = "Update an existing slot")
    public ResponseEntity<Slot> updateSlot(@PathVariable Integer id, @RequestBody Slot slot) {
        slot.setId(id);
        Slot updatedSlot = slotService.updateSlot(slot);
        return ResponseEntity.ok(updatedSlot);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a slot", description = "Delete a slot by its ID")
    public ResponseEntity<Void> deleteSlot(@PathVariable Integer id) {
        slotService.deleteSlot(id);
        return ResponseEntity.noContent().build();
    }
}
