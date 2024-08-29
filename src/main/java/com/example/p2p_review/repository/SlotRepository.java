package com.example.p2p_review.repository;


import com.example.p2p_review.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
    List<Slot> findByExpertUserEmployeeIdAndAvailableTrueAndStartTimeBetween(
            Integer employeeId, LocalDateTime startTime, LocalDateTime endTime);
}





