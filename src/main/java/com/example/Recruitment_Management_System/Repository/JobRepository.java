package com.example.Recruitment_Management_System.Repository;


import com.example.Recruitment_Management_System.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
