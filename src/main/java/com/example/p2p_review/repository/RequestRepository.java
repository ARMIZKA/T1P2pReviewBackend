package com.example.p2p_review.repository;


import com.example.p2p_review.model.Request;
import com.example.p2p_review.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByCustomer(User customer);
    List<Request> findByExpert(User expert);
}

