package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.SchoolYear.SchoolYearRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolYear.SchoolYearResponseDto;
import com.example.schoolManagementSystem.entities.SchoolYear;

public class SchoolYearMapper {
    public static SchoolYear toEntity(SchoolYearRequestDto dto) {
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setYearName(dto.getYearName());
        schoolYear.setStartDate(dto.getStartDate());
        schoolYear.setEndDate(dto.getEndDate());
        return schoolYear;
    }

    public static void updateEntity(SchoolYear schoolYear, SchoolYearRequestDto dto) {
        schoolYear.setYearName(dto.getYearName());
        schoolYear.setStartDate(dto.getStartDate());
        schoolYear.setEndDate(dto.getEndDate());
    }

    public static SchoolYearResponseDto toDto(SchoolYear entity) {
        return new SchoolYearResponseDto(
                entity.getId(),
                entity.getYearName(),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }
}
