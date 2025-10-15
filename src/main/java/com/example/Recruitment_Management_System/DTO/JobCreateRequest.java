package com.example.Recruitment_Management_System.DTO;


import lombok.Data;

@Data
public class JobCreateRequest {
    private String title;
    private String description;
    private String companyName;
}