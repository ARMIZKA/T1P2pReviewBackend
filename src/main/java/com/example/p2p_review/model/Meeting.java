package com.example.p2p_review.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "expert_id")
    private Integer expertId;

    @Getter
    @Setter
    @ManyToOne
    private Slot slot;

    private LocalDateTime meetingTime;
    private String result;

}

