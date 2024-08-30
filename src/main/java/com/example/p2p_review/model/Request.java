package com.example.p2p_review.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer expertId;

    private LocalDateTime createdAt;
    private String status;

    @Lob
    private String userComment;

    @Lob
    private String expertComment;

    @Lob
    private byte[] userFile;

    @Lob
    private byte[] expertFile;
}
