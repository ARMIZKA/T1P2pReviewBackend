package com.example.p2p_review.repository;

import com.example.p2p_review.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findByUserId(Integer userId);


    List<Request> findByExpertId(Integer expertId);

    List<Request> findByUserIdAndExpertId(Integer userId, Integer expertId);
}
