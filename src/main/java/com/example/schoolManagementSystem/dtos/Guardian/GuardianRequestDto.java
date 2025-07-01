package com.example.schoolManagementSystem.dtos.Guardian;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class GuardianRequestDto {
    @NotBlank
    private String guardianFirstname;

    @NotBlank
    private String guardianLastname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    public GuardianRequestDto() {
    }

    public GuardianRequestDto(String guardianFirstname, String guardianLastname, String email, String phoneNumber) {
        this.guardianFirstname = guardianFirstname;
        this.guardianLastname = guardianLastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
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
