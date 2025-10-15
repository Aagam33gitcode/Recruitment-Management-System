package com.example.Recruitment_Management_System.Service;

import com.example.Recruitment_Management_System.DTO.JwtAuthenticationResponse;
import com.example.Recruitment_Management_System.DTO.LoginRequest;
import com.example.Recruitment_Management_System.DTO.SignUpRequest;


public interface AuthService {
    String registerUser(SignUpRequest signUpRequest);
    JwtAuthenticationResponse loginUser(LoginRequest loginRequest);
}
