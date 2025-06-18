package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "guardians")
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guardiant_seq")
    @SequenceGenerator(name = "guardiant_seq", sequenceName = "guardiant_seq", allocationSize = 1)
    private Long id;

    @Column(name = "guardian_firstname", nullable = false)
    private String guardianFirstname;

    @Column(name = "guardian_lastname", nullable = false)
    private String guardianLastname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public Guardian() {}

    public Guardian(Long id, String guardianFirstname, String guardianLastname, String email, String phoneNumber) {
        this.id = id;
        this.guardianFirstname = guardianFirstname;
        this.guardianLastname = guardianLastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
