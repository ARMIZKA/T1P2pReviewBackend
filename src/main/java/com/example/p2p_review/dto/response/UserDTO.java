package com.example.p2p_review.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"id", "firstName", "lastName", "patronymic", "dateOfBirth",
        "gender", "location", "post", "role", "specialization"})
public record UserDTO(
        int id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        String patronymic,
        @JsonProperty("date_of_birth")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dateOfBirth,
        String gender,
        String location,
        String post,
        String role,
        String specialization
) {
}

