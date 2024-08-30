package com.example.p2p_review.service;

import com.example.p2p_review.model.Request;
import com.example.p2p_review.repository.RequestRepository;
import com.example.p2p_review.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    public RequestService(RequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    public List<Request> findRequestsByUser(Integer userId) {
        return requestRepository.findByUserId(userId);
    }

    public List<Request> findRequestsByExpert(Integer expertId) {
        return requestRepository.findByExpertId(expertId);
    }

    public Request createRequest(Request request, MultipartFile userFile, String userComment) throws IOException {
        request.setCreatedAt(java.time.LocalDateTime.now());
        request.setUserComment(userComment);

        if (userFile != null && !userFile.isEmpty()) {
            request.setUserFile(userFile.getBytes());
        }

        return requestRepository.save(request);
    }

    public void addUserResponse(Integer requestId, MultipartFile userFile, String userComment) throws IOException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));

        if (userFile != null && !userFile.isEmpty()) {
            request.setUserFile(userFile.getBytes());
        }

        request.setUserComment(userComment);
        requestRepository.save(request);
    }

    public void addExpertResponse(Integer requestId, MultipartFile expertFile, String expertComment) throws IOException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));

        if (expertFile != null && !expertFile.isEmpty()) {
            request.setExpertFile(expertFile.getBytes());
        }

        request.setExpertComment(expertComment);
        requestRepository.save(request);
    }

    public void updateRequestStatus(Integer requestId, String status) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));
        request.setStatus(status);
        requestRepository.save(request);
    }

    public void cancelRequest(Integer requestId) {
        requestRepository.deleteById(requestId);
    }
}
