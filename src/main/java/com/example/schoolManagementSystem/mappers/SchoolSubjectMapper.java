package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.SchoolSubject.SchoolSubjectRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolSubject.SchoolSubjectResponseDto;
import com.example.schoolManagementSystem.entities.Department;
import com.example.schoolManagementSystem.entities.SchoolSubject;

public class SchoolSubjectMapper {

    public static SchoolSubject toEntity(SchoolSubjectRequestDto dto, Department department) {
        SchoolSubject subject = new SchoolSubject();
        subject.setSubjectName(dto.getSubjectName());
        subject.setDepartment(department);
        return subject;
    }

    public static void updateEntity(SchoolSubject subject, SchoolSubjectRequestDto dto, Department department) {
        subject.setSubjectName(dto.getSubjectName());
        subject.setDepartment(department);
    }

    public static SchoolSubjectResponseDto toDto(SchoolSubject subject) {
        return new SchoolSubjectResponseDto(
                subject.getId(),
                subject.getSubjectName(),
                subject.getDepartment().getId(),
                subject.getDepartment().getDepartmentName()
        );
    }
}
