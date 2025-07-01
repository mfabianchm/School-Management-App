package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.StudentGuardian.StudentGuardianResponseDto;
import com.example.schoolManagementSystem.entities.StudentGuardian;

public class StudentGuardianMapper {
    public static StudentGuardianResponseDto toDto(StudentGuardian entity) {
        return new StudentGuardianResponseDto(
                entity.getId(),
                entity.getStudent().getId(),
                entity.getGuardian().getId(),
                entity.getGuardianType().getGuardianType().name()
        );
    }
}
