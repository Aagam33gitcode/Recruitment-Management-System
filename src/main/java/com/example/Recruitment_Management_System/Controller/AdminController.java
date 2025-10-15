package com.example.Recruitment_Management_System.Controller;


import com.example.Recruitment_Management_System.DTO.JobCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAuthority('Admin')")
public class AdminController {



    @PostMapping("/job")
    public ResponseEntity<?> createJobOpening(@RequestBody JobCreateRequest jobCreateRequest) {
        return ResponseEntity.ok("Job created successfully.");
    }

    @GetMapping("/job/{job_id}")
    public ResponseEntity<?> getJobDetails(@PathVariable("job_id") Long jobId) {
        return ResponseEntity.ok("Details for job " + jobId + " and its applicants.");
    }

    @GetMapping("/applicants")
    public ResponseEntity<?> getAllApplicants() {
        return ResponseEntity.ok("List of all applicants in the system.");
    }

    @GetMapping("/applicant/{applicant_id}")
    public ResponseEntity<?> getApplicantData(@PathVariable("applicant_id") Long applicantId) {
        return ResponseEntity.ok("Extracted data for applicant " + applicantId);
    }
}
