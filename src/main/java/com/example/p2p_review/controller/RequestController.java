package com.example.p2p_review.controller;

import com.example.p2p_review.model.Request;
import com.example.p2p_review.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Requests", description = "API for managing requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    @Operation(summary = "Get my requests", description = "Retrieve a list of requests created by the current user")
    public ResponseEntity<List<Request>> getMyRequests(@RequestParam Integer userId) {
        List<Request> requests = requestService.findRequestsByUser(userId);
        return ResponseEntity.ok(requests);
    }

    @PostMapping
    @Operation(summary = "Create a new request", description = "Create a new request")
    public ResponseEntity<Request> createRequest(
            @RequestParam("userId") Integer userId,
            @RequestParam("expertId") Integer expertId,
            @RequestParam(value = "userFile", required = false) MultipartFile userFile,
            @RequestParam(value = "userComment", required = false) String userComment) throws IOException {

        Request request = new Request();
        request.setUserId(userId);
        request.setExpertId(expertId);

        Request createdRequest = requestService.createRequest(request, userFile, userComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}/user-response")
    @Operation(summary = "Add user response", description = "Add a user's response to a request")
    public ResponseEntity<Void> addUserResponse(
            @PathVariable Integer id,
            @RequestParam(value = "userFile", required = false) MultipartFile userFile,
            @RequestParam(value = "userComment", required = false) String userComment) throws IOException {

        requestService.addUserResponse(id, userFile, userComment);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/expert-response")
    @Operation(summary = "Add expert response", description = "Add an expert's response to a request")
    public ResponseEntity<Void> addExpertResponse(
            @PathVariable Integer id,
            @RequestParam(value = "expertFile", required = false) MultipartFile expertFile,
            @RequestParam(value = "expertComment", required = false) String expertComment) throws IOException {

        requestService.addExpertResponse(id, expertFile, expertComment);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update request status", description = "Update the status of a request")
    public ResponseEntity<Void> updateRequestStatus(@PathVariable Integer id, @RequestParam String status) {
        requestService.updateRequestStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancel request", description = "Cancel a request by its ID")
    public ResponseEntity<Void> cancelRequest(@PathVariable Integer id) {
        requestService.cancelRequest(id);
        return ResponseEntity.noContent().build();
    }
}
