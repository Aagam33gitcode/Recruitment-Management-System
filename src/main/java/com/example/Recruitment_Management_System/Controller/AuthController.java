package com.example.Recruitment_Management_System.Controller;


import com.example.Recruitment_Management_System.DTO.JwtAuthenticationResponse;
import com.example.Recruitment_Management_System.DTO.LoginRequest;
import com.example.Recruitment_Management_System.DTO.SignUpRequest;
import com.example.Recruitment_Management_System.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        try {
            String response = authService.registerUser(signUpRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login") //
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtAuthenticationResponse response = authService.loginUser(loginRequest);
        return ResponseEntity.ok(response);
    }
}