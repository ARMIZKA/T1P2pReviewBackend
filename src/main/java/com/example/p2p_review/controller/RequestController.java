package com.example.p2p_review.controller;


import com.example.p2p_review.model.Request;
import com.example.p2p_review.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Requests", description = "API for managing requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/my")
    @Operation(summary = "Get my requests", description = "Retrieve a list of requests created by the current user")
    public ResponseEntity<List<Request>> getMyRequests(@RequestParam Integer userId) {
        List<Request> requests = requestService.findRequestsByUser(userId);
        return ResponseEntity.ok(requests);
    }

    @PostMapping
    @Operation(summary = "Create a new request", description = "Create a new request")
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request createdRequest = requestService.createRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update request status", description = "Update the status of a request")
    public ResponseEntity<Void> updateRequestStatus(@PathVariable Long id, @RequestParam String status) {
        requestService.updateRequestStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancel request", description = "Cancel a request by its ID")
    public ResponseEntity<Void> cancelRequest(@PathVariable Long id) {
        requestService.cancelRequest(id);
        return ResponseEntity.noContent().build();
    }
}
