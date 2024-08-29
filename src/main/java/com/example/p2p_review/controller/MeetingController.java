package com.example.p2p_review.controller;


import com.example.p2p_review.model.Meeting;
import com.example.p2p_review.model.Slot;
import com.example.p2p_review.service.MeetingService;
import com.example.p2p_review.service.SlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/meetings")
@Tag(name = "Meetings", description = "API for managing and booking meetings")
public class MeetingController {

    private final MeetingService meetingService;
    private final SlotService slotService;

    public MeetingController(MeetingService meetingService, SlotService slotService) {
        this.meetingService = meetingService;
        this.slotService = slotService;
    }

    @PostMapping("/book")
    @Operation(summary = "Book a slot", description = "Book a meeting for a specific slot")
    public ResponseEntity<Meeting> bookSlot(@RequestParam Integer slotId, @RequestBody Meeting meeting) {
        Optional<Slot> slot = slotService.getSlotById(slotId);

        if (slot.isPresent() && slot.get().isAvailable()) {
            meeting.setSlot(slot.get());
            Meeting bookedMeeting = meetingService.bookMeeting(meeting);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookedMeeting);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
