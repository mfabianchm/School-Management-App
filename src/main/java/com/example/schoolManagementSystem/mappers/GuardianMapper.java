package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Guardian.GuardianRequestDto;
import com.example.schoolManagementSystem.dtos.Guardian.GuardianResponseDto;
import com.example.schoolManagementSystem.entities.Guardian;

public class GuardianMapper {
    public static Guardian toEntity(GuardianRequestDto dto) {
        return new Guardian(null, dto.getGuardianFirstname(), dto.getGuardianLastname(), dto.getEmail(), dto.getPhoneNumber());
    }

    public static GuardianResponseDto toDto(Guardian guardian) {
        return new GuardianResponseDto(
                guardian.getId(),
                guardian.getGuardianFirstname(),
                guardian.getGuardianLastname(),
                guardian.getEmail(),
                guardian.getPhoneNumber()
        );
    }

    public static void updateEntity(Guardian guardian, GuardianRequestDto dto) {
        guardian.setGuardianFirstname(dto.getGuardianFirstname());
        guardian.setGuardianLastname(dto.getGuardianLastname());
        guardian.setEmail(dto.getEmail());
        guardian.setPhoneNumber(dto.getPhoneNumber());
    }
}
