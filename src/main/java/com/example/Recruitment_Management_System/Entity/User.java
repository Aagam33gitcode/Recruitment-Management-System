package com.example.Recruitment_Management_System.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // [cite: 27]

    @Column(nullable = false, unique = true)
    private String email; // [cite: 28]

    @Column(nullable = false)
    private String passwordHash; // [cite: 31]

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType; // [cite: 30]

    private String profileHeadline; // [cite: 32]
    private String address; // [cite: 29]

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile; // [cite: 33]
}
