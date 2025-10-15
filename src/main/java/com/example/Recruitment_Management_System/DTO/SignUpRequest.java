package com.example.Recruitment_Management_System.DTO;

import com.example.Recruitment_Management_System.Entity.UserType;
import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private UserType userType;
    private String profileHeadline;
    private String address;
}