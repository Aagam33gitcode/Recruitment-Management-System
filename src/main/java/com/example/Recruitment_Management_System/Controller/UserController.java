package com.example.Recruitment_Management_System.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class UserController {


    @PostMapping("/uploadResume")
    @PreAuthorize("hasAuthority('Applicant')")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok("Resume uploaded and processed successfully.");
    }

    @GetMapping("/jobs")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getJobOpenings() {
        return ResponseEntity.ok("List of all job openings returned here.");
    }

    @GetMapping("/jobs/apply")
    @PreAuthorize("hasAuthority('Applicant')")
    public ResponseEntity<?> applyForJob(@RequestParam("job_id") Long jobId) {
        return ResponseEntity.ok("Successfully applied for job with ID: " + jobId);
    }
}