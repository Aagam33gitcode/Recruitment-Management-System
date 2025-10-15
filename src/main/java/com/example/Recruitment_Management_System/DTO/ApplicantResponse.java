package com.example.Recruitment_Management_System.DTO;


import lombok.Data;

@Data
public class ApplicantResponse {
    private Long id;
    private String name;
    private String email;
    private String profileHeadline;
}
