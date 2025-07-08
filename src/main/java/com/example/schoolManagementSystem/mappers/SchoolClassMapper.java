package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.SchoolClass.SchoolClassResponseDto;
import com.example.schoolManagementSystem.entities.SchoolClass;

public class SchoolClassMapper {

    public static SchoolClassResponseDto toDto(SchoolClass schoolClass) {
        return new SchoolClassResponseDto(
                schoolClass.getId(),
                schoolClass.getName(),
                schoolClass.getSubject().getId(),
                schoolClass.getTeacher().getId(),
                schoolClass.getTerm().getId(),
                schoolClass.getPeriod().getStartTime(),
                schoolClass.getPeriod().getEndTime(),
                schoolClass.getClassroom().getId()
        );
    }


}
