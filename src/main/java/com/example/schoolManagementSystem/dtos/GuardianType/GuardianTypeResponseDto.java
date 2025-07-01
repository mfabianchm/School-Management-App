package com.example.schoolManagementSystem.dtos.GuardianType;

public class GuardianTypeResponseDto {
    private Long id;
    private String guardianType;

    public GuardianTypeResponseDto() {}

    public GuardianTypeResponseDto(Long id, String guardianType) {
        this.id = id;
        this.guardianType = guardianType;
    }

    public Long getId() {
        return id;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }
}
