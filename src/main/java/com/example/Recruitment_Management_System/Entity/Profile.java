package com.example.Recruitment_Management_System.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String resumeFileAddress;

    @Lob
    private String skills;

    @Lob
    private String education;

    @Lob
    private String experience;

    private String name;
    private String email;
    private String phone;
}
