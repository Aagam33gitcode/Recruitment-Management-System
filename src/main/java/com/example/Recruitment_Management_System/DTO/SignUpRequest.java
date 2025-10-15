package com.example.Recruitment_Management_System.DTO;


import com.example.Recruitment_Management_System.Entity.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotBlank
    @Size(min = 3, max = 40)
    private String name;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private UserType userType;

    private String profileHeadline;
    private String address;
}