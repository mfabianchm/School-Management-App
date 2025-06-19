package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;

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

    // Constructors
    public Guardian() {}

    public Guardian(Long id, String guardianFirstname, String guardianLastname, String email, String phoneNumber) {
        this.id = id;
        this.guardianFirstname = guardianFirstname;
        this.guardianLastname = guardianLastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuardianFirstname() {
        return guardianFirstname;
    }

    public void setGuardianFirstname(String guardianFirstname) {
        this.guardianFirstname = guardianFirstname;
    }

    public String getGuardianLastname() {
        return guardianLastname;
    }

    public void setGuardianLastname(String guardianLastname) {
        this.guardianLastname = guardianLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guardian)) return false;
        Guardian guardian = (Guardian) o;
        return Objects.equals(id, guardian.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Guardian{" +
                "id=" + id +
                ", guardianFirstname='" + guardianFirstname + '\'' +
                ", guardianLastname='" + guardianLastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
