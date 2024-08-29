package com.example.p2p_review.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String image;
    private String city;
    private String birthday;
    private String position;
    private String experience;
    private String skills;
    private String responsibility_area;
    private String phone_number;
    private Boolean anonymity;
    private String email;
    private String tg_id;
}
