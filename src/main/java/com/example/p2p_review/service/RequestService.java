package com.example.p2p_review.service;




import com.example.p2p_review.model.Request;
import com.example.p2p_review.model.User;
import com.example.p2p_review.repository.RequestRepository;
import com.example.p2p_review.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    public RequestService(RequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    public List<Request> findRequestsByUser(Integer userId) {
        Optional<User> user = userRepository.findById(Math.toIntExact(userId));
        if (user.isPresent()) {
            return requestRepository.findByCustomer(user.get());
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public Request createRequest(Request request) {
        request.setCreatedAt(java.time.LocalDateTime.now());
        return requestRepository.save(request);
    }

    public void updateRequestStatus(Long requestId, String status) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));
        request.setStatus(status);
        requestRepository.save(request);
    }

    public void cancelRequest(Long requestId) {
        requestRepository.deleteById(requestId);
    }
}


