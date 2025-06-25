package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Period.PeriodRequestDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodResponseDto;
import com.example.schoolManagementSystem.entities.Period;
import com.example.schoolManagementSystem.entities.SchoolYear;

public class PeriodMapper {
    public static Period toEntity(PeriodRequestDto dto, SchoolYear schoolYear) {
        return new Period(null, schoolYear, dto.getPeriodName(), dto.getStartTime(), dto.getEndTime());
    }

    public static void updateEntity(Period period, PeriodRequestDto dto, SchoolYear schoolYear) {
        period.setPeriodName(dto.getPeriodName());
        period.setStartTime(dto.getStartTime());
        period.setEndTime(dto.getEndTime());
        period.setSchoolYear(schoolYear);
    }

    public static PeriodResponseDto toDto(Period period) {
        return new PeriodResponseDto(
                period.getId(),
                period.getPeriodName(),
                period.getStartTime(),
                period.getEndTime(),
                period.getSchoolYear().getId()
        );
    }
}
