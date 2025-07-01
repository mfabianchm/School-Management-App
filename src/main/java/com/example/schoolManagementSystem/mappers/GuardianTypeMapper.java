package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.GuardianType.GuardianTypeRequestDto;
import com.example.schoolManagementSystem.dtos.GuardianType.GuardianTypeResponseDto;
import com.example.schoolManagementSystem.entities.GuardianType;
import com.example.schoolManagementSystem.enums.GuardianTypes;

public class GuardianTypeMapper {
    public static GuardianTypeResponseDto toDto(GuardianType entity) {
        return new GuardianTypeResponseDto(entity.getId(), entity.getGuardianType().name());
    }

    public static GuardianType toEntity(GuardianTypeRequestDto dto) {
        GuardianTypes type = GuardianTypes.valueOf(dto.getGuardianType().toUpperCase());
        return new GuardianType(null, type);
    }
}
