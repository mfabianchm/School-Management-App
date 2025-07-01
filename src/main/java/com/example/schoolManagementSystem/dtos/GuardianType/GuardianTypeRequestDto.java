package com.example.schoolManagementSystem.dtos.GuardianType;

import jakarta.validation.constraints.NotBlank;

public class GuardianTypeRequestDto {

    @NotBlank(message = "guardianType is required")
    private String guardianType;

    public GuardianTypeRequestDto() {
    }

    public GuardianTypeRequestDto(String guardianType) {
        this.guardianType = guardianType;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }
}
