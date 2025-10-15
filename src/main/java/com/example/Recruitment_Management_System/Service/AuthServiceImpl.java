package com.example.Recruitment_Management_System.Service;


import com.example.Recruitment_Management_System.DTO.JwtAuthenticationResponse;
import com.example.Recruitment_Management_System.DTO.LoginRequest;
import com.example.Recruitment_Management_System.DTO.SignUpRequest;
import com.example.Recruitment_Management_System.Entity.User;
import com.example.Recruitment_Management_System.Repository.UserRepository;
import com.example.Recruitment_Management_System.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public String registerUser(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Email Address already in use!");
        }

        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setAddress(signUpRequest.getAddress());
        user.setUserType(signUpRequest.getUserType());
        user.setProfileHeadline(signUpRequest.getProfileHeadline());
        user.setPasswordHash(passwordEncoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public JwtAuthenticationResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return new JwtAuthenticationResponse(jwt);
    }
}
