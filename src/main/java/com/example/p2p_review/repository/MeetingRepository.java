package com.example.p2p_review.repository;


import com.example.p2p_review.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}

