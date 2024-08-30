package com.example.p2p_review.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Data
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @Column(name = "expert_id", nullable = false)
    private Integer expertId;

    // @Column(name = "user_id")
    private Integer userId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Getter
    private Boolean available;


}

