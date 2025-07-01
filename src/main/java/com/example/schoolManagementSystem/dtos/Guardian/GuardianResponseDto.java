package com.example.schoolManagementSystem.dtos.Guardian;

public class GuardianResponseDto {
    private Long id;
    private String guardianFirstname;
    private String guardianLastname;
    private String email;
    private String phoneNumber;

    public GuardianResponseDto() {
    }

    public GuardianResponseDto(Long id, String guardianFirstname, String guardianLastname, String email, String phoneNumber) {
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
}
