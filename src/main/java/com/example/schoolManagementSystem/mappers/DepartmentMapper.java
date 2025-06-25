package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Department.DepartmentRequestDto;
import com.example.schoolManagementSystem.dtos.Department.DepartmentResponseDto;
import com.example.schoolManagementSystem.entities.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentRequestDto dto) {
        return new Department(dto.getDepartmentName());
    }

    public static void updateEntity(Department department, DepartmentRequestDto dto) {
        department.setDepartmentName(dto.getDepartmentName());
    }

    public static DepartmentResponseDto toDto(Department department) {
        return new DepartmentResponseDto(department.getId(), department.getDepartmentName());
    }
}
